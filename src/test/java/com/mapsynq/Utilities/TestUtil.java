package com.mapsynq.Utilities;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.mapsynq.Base.TestBase;

import ru.yandex.qatools.ashot.Screenshot;

public class TestUtil extends TestBase
{
	
	public static String screenShotPath;
    public static String screenShotName;
    public static String screenShotImageName;
    public static String screenShotPathashot;
    public static String screenShotNameashot;
    public static String screenShotImageNameashot;
    public static Screenshot screenshot;
    
	public static String captureScreenshot() 
	{
	   try
	   {   Date d=new Date();
		   screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		   screenShotPath=System.getProperty("user.dir")+"\\target\\surefire-reports\\";
		   screenShotImageName=screenShotPath+screenShotName;
		     
		   File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE)	;
		   FileUtils.copyFile(srcFile, new File(screenShotImageName));
	   }
		catch(Exception e) 
		{
			log.error("Issue with taking screenshot: "+e.getMessage().toString());
			
		}
	   
	    return screenShotImageName;
	   
	}
	
	public static void selectDate(WebElement element,String Date)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		String script= "arguments[0].setAttribute('value','"+Date+"');";
		jse.executeScript(script, element);		
	}

}
