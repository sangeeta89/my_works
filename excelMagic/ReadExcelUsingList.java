/**
 * 
 */
package excelMagic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Sangeeta
 * @param <readExcel>
 * @param <Map>
 *
 */
public class ReadExcelUsingList{

	/**
	 * @param args
	 */
	
	public static XSSFWorkbook mybook;
	public static XSSFSheet sheet1,sheet2;
	public static FileInputStream fis; public static XSSFCell cell1;
	public static XSSFRow row1,row2;
	public static XSSFCell cell;
	public static int sheet1totalRows,sheet2totalRows,sh1eachRowValue,sh2eachRowValue,sh1eachColValue,sh2eachColValue;
	public static String sh1columnData;
	public static String sh2columnData;
	public static List<String> arrayValues=new ArrayList<String>();
	public static HashMap<String, String> hashmap=new HashMap<String, String>();
	
	public void readExcel() throws Exception{
		fis=new FileInputStream("E:\\testsuites\\mydata.xlsx");
		mybook=new XSSFWorkbook(fis);
		sheet1=mybook.getSheet("Config");
		sheet2=mybook.getSheet("TestData");
			
	}
	void readValuesFromConfig() throws Exception
	{	
		System.out.print("Sheet1");
		sheet1totalRows= sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		for (sh1eachRowValue=0; sh1eachRowValue<sheet1totalRows;sh1eachRowValue++)
		{
			row1=sheet1.getRow(sh1eachRowValue);
			System.out.println();
			for(sh1eachColValue=0;sh1eachColValue<row1.getLastCellNum();sh1eachColValue++)
			{	
				
				sh1columnData=(row1.getCell(sh1eachColValue).getStringCellValue()+ "\t");
				System.out.print(sh1columnData);
				arrayValues.add(sh1columnData.toString());
				
			}
			
			
		}
		System.out.println("\n=================");
	}
	void readValuesFromTestData() throws Exception
	{
		System.out.print("\nSheet2");
		System.out.println("\n======================================================");
		sheet2totalRows=  sheet2.getLastRowNum()-sheet2.getFirstRowNum();

		for (sh2eachRowValue=0;sh2eachRowValue<sheet2totalRows+1;sh2eachRowValue++)
		{

			row2=sheet2.getRow(sh2eachRowValue);
			System.out.println();
			for(sh2eachColValue=0;sh2eachColValue<row2.getLastCellNum();sh2eachColValue++)
			{	
			
				sh2columnData=(row2.getCell(sh2eachColValue).getStringCellValue()+ "\t");
				System.out.print(sh2columnData);
				arrayValues.add(sh2columnData.toString());
			}
		}
		System.out.println("\n======================================================");
		fis.close();
	}
		
	public static void main(String[] args) throws Exception 
	{
		
		ReadExcelUsingList readob=new ReadExcelUsingList();
		readob.readExcel();
		readob.readValuesFromConfig();
		readob.readValuesFromTestData();
		
	}

}

