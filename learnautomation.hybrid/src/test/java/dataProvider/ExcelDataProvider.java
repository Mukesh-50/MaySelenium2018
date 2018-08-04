package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		try 
		{
			wb=new XSSFWorkbook(new FileInputStream(new File("./TestData/ApplicationData.xlsx")));
			
		} catch (Exception e) 
		{
			System.out.println("Not able to load Excel file, Please check error log "+e.getMessage());
		} 
	}
	
	public String getStringData(String SheetName,int row,int column)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(int SheetIndex,int row,int column)
	{
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericDataDouble(String SheetName,int row,int column)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();

	}
	
	public int getNumericDataInt(String SheetName,int row,int column)
	{
		return  (int) wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();

	}
	
	public int getNumberOfRows(String SheetName)
	{
		return wb.getSheet(SheetName).getPhysicalNumberOfRows();
	}
	
	public int getNumberOfColumns(String SheetName,int row)
	{
		return wb.getSheet(SheetName).getRow(row).getPhysicalNumberOfCells();
	}
	
}
