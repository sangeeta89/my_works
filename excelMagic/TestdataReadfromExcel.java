package excelMagic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestdataReadfromExcel {

	public static String filepath="E:\\testsuites\\mydata.xlsx";
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet,sheet1;
	public static XSSFRow row,row1;
	public static XSSFCell cell;
	public static int noOfRows,noOfRows1,eachRowValue,eachRowValue1,eachColValue,eachColValue1;
	public static String columnData,columnData1,innercolumnData1;
	public static FileInputStream fis;
	

		
	void ReadfromConfig() throws Exception
	{
		
		fis = new FileInputStream(filepath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheetAt(0);
		 noOfRows=  sheet.getLastRowNum()-sheet.getFirstRowNum();
	}
	void readValuesFromConfig() throws NullPointerException
	{	
		for (eachRowValue=0;eachRowValue<noOfRows+1;eachRowValue++)
		{

			row=sheet.getRow(eachRowValue);
			System.out.println();
			
			
			for(eachColValue=0;eachColValue<row.getLastCellNum();eachColValue++)
			{	
				columnData=(row.getCell(eachColValue).getStringCellValue()+ "\t");
				System.out.print(columnData);
			

				
			}
			
		}
	}
	
	
	void readValuesFromTestData() throws Exception
	{
		
		sheet1=wb.getSheetAt(1);

		noOfRows1=  sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		for (eachRowValue1=0;eachRowValue1<noOfRows1+1;eachRowValue1++)
		{

			row1=sheet1.getRow(eachRowValue1);
			System.out.println();
			for(eachColValue1=0;eachColValue1<row1.getLastCellNum();eachColValue1++)
			{	
			
				columnData1=(row1.getCell(eachColValue1).getStringCellValue()+ "\t");
				System.out.print(columnData1);

			}
		}
		
		fis.close();
	}
	
				
					
			
		
	
	public static void main(String[] args) throws Exception
	{
		TestdataReadfromExcel testobj=new TestdataReadfromExcel();
		testobj.ReadfromConfig();
		testobj.readValuesFromConfig();
		testobj.readValuesFromTestData();
		System.out.println("Console print");

	}

}
