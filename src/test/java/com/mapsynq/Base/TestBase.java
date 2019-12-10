package com.mapsynq.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mapsynq.Utilities.ExcelReader;
import com.mapsynq.Utilities.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	public static  WebDriver driver;
	
	 public static  Properties config=new Properties();
	 public static  Properties testdata=new Properties();
	 public static  FileInputStream fis;
	 public static WebDriverWait wait;
	 public static String browser;
	 public static Logger log=Logger.getLogger("rootLogger");
	 public static ExtentReports rep=ExtentManager.getInstance();
	 public static ExtentTest test;
	 public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
	 
	 @BeforeSuite(description="Suite started")
		public static void BeforeSuite() throws FileNotFoundException, IOException
	 	{		
			if(driver==null)
			{
				  	fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
					config.load(fis);
					fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\TestData.properties");
					testdata.load(fis);
					log.debug("Logs initialized");
					log.debug("Suite Started");
			}
	 	}
	 
	 @BeforeTest(description="Driver initilization and pre test setup")
		public void BeforeTest() 
	   {
		 String browser = config.getProperty("browser");
		 if(browser.equals("Chrome"))
		 {  		 
  		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\chromedriver.exe");
  		   driver=new ChromeDriver();
  		   System.out.println("Chrome Driver Luanched");
		 }
		 else if(browser.equalsIgnoreCase("firefox"))
		 {  		 
  		   System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Executables\\geckodriver.exe");
  		   driver=new ChromeDriver();
  		   System.out.println("Chrome Driver Luanched");
		 }
		 else if(browser.equalsIgnoreCase("phantomjs"))
		 {
			 	WebDriverManager.phantomjs().setup();		
				Capabilities caps = new DesiredCapabilities();
				((DesiredCapabilities) caps).setJavascriptEnabled(true);
				((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
				driver = new PhantomJSDriver(caps);		 
	     }
		 
	   driver.manage().deleteAllCookies();
	   driver.get(config.getProperty("TestsuiteURL"));
   	   driver.manage().window().maximize();
   	   driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(config.getProperty("PageLoadTime")), TimeUnit.SECONDS);
   	   driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("ImplicitTime")), TimeUnit.SECONDS);
   	   wait=new WebDriverWait(driver,5); 
   	   
	   }
	 
		@AfterTest(description="Driver teardown")
		public void AfterTest() {
			driver.quit();
			log.debug("Driver quit.");
		}
		
		@AfterSuite(description="Suite ended")
		public void AfterSuite() {
			rep.flush();
			log.debug("Report Flushed");
			log.debug("Suite ended");
		} 
	 
}
