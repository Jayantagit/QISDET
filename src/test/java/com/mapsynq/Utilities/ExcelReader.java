package com.mapsynq.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	
	public String path;
	public FileInputStream fis=null;
	public FileOutputStream fileout=null;
	
	private XSSFWorkbook workbook=null;
	private XSSFSheet sheet=null;
	private XSSFRow row=null;
	private XSSFCell cell=null;
	
	
	public ExcelReader(String path)
	{
		this.path=path;
		try
		{
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheetAt(0);
			fis.close();			
			
		}
		catch(Exception e)
		{
			
					
			
		}
	}
	
	public int getRowCount(String sheetname)
	{
		sheet=workbook.getSheet(sheetname);
		return sheet.getLastRowNum();
	}
	
	public int getColumnCount(String sheetname)
	{
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(0);
		return row.getLastCellNum();
	}
	
	
	public String getCellData(String sheetName, String colName, int rowNum)
    {
		//Row and column starting with zero
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(0);
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num = i;
            }
 
            row = sheet.getRow(rowNum);
            cell = row.getCell(col_Num);
            
           return cell.getStringCellValue();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist  in Excel";
        }
    }
	

}
