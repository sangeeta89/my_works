package excelMagic.excelMagic;
/**
 * 
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Sangeeta
 * @param <readExcel>
 * @param <Map>
 *
 */
public class ExcelReadWithMap{

	/**
	 * @param args
	 */
	
	public static XSSFWorkbook mybook;
	public static XSSFSheet sheet1,sheet2;
	public static FileInputStream fis; 
	public static XSSFRow row1,row2;


	public static String sh1columnData;
	public static String sh2columnData;

	//Note: map should be created as key(string/id) and value (object)
	public static HashMap<String, TestData> tdMap=new HashMap<String, TestData>();
	public static HashMap<String, Integer> tdKeyMap=new HashMap<String, Integer>();
	public static HashMap<String, ConfigData> CdMap=new HashMap<String, ConfigData>();
	public static HashMap<String, Integer> ConfigKeyMap=new HashMap<String, Integer>();
	public static String sheet1keycell,sheet1value,sheet2keycell,sheet2value;
	
	public void readExcel() throws Exception{
		fis=new FileInputStream("E:\\testsuites\\myexcel.xlsx");
		mybook=new XSSFWorkbook(fis);
		sheet1=mybook.getSheet("Config");
		sheet2=mybook.getSheet("TestData");
	}
	
	public static void generateTestDataMap() {
		int sheet2totalRows, sh2eachRowValue, sh2eachColValue;
		sheet2totalRows=  sheet2.getLastRowNum() - sheet2.getFirstRowNum();
		for (sh2eachRowValue=0;sh2eachRowValue<=sheet2totalRows;sh2eachRowValue++) 
		{
			row2=sheet2.getRow(sh2eachRowValue);
			if ( sh2eachRowValue == 0)	{
				for(sh2eachColValue=0;sh2eachColValue<row2.getLastCellNum();sh2eachColValue++) 
				{
					String headerKey = row2.getCell(sh2eachColValue).getStringCellValue();
					tdKeyMap.put(headerKey, sh2eachColValue);
				}
			}
			
			TestData tdObj = new TestData();
			String key = row2.getCell(0).getStringCellValue();
			tdObj.setName(row2.getCell(tdKeyMap.get("testName")).getStringCellValue());
			tdObj.setUname(row2.getCell(tdKeyMap.get("uname")).getStringCellValue());
			tdObj.setPassword(row2.getCell(tdKeyMap.get("pass")).getStringCellValue());
			tdObj.setEmail(row2.getCell(tdKeyMap.get("email")).getStringCellValue());
			
//			tdObj.setName(row2.getCell(0).getStringCellValue());
//			tdObj.setUname(row2.getCell(1).getStringCellValue());
//			tdObj.setPassword(row2.getCell(2).getStringCellValue());
//			tdObj.setEmail(row2.getCell(3).getStringCellValue());
			
			tdMap.put(key, tdObj);
		}
	//	System.out.println(tdMap.get("Testcase2").getName());
	}
	
//	public static void printTestDataBasedOnConfig() throws Exception
//	{	
//		
//		System.out.println("Sheet1");
//		int sheet1totalRows, sh1eachRowValue, sh1eachColValue;
//		sheet1totalRows= sheet1.getLastRowNum()-sheet1.getFirstRowNum();
//		
//		for (sh1eachRowValue=0; sh1eachRowValue<sheet1totalRows;sh1eachRowValue++)
//		{
//			row1=sheet1.getRow(sh1eachRowValue);
//			for(sh1eachColValue=1;sh1eachColValue<=row1.getLastCellNum();sh1eachColValue++)
//			{
//				String testKey = row1.getCell(0).getStringCellValue();
//				String runFlag = row1.getCell(1).getStringCellValue();
//					if (runFlag.equalsIgnoreCase("n")) 
//					{
//						TestData data = getTestDataByKey(testKey);
//						System.out.println(data.toString());
//						//Note: get data from the map and print individual value like below
//		//				System.out.println(data.getName());
//		//				System.out.println(data.getEmail());
//		//				System.out.println(data.getUname());
//		//				System.out.println(data.getPassword());
//					}
//					
//			}
//			System.out.println("\n=================");
//			
//		}
//			
//	}			
//	
//checking config -data map to find out key and value if data changes dynamically
	
	public static void printTestDataBasedOnConfig() throws Exception
	{	
		
		System.out.println("Sheet1");
		int sheet1totalRows, sh1eachRowValue, sh1eachColValue;
		sheet1totalRows= sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		
		for (sh1eachRowValue=0; sh1eachRowValue<sheet1totalRows;sh1eachRowValue++)
		{
			row1=sheet1.getRow(sh1eachRowValue);
			for(sh1eachColValue=0;sh1eachColValue<row1.getLastCellNum();sh1eachColValue++)
				{
					if(sh1eachRowValue==0)
					{
						String ConfigHeadkey=row1.getCell(0).getStringCellValue();
						ConfigKeyMap.put(ConfigHeadkey,sh1eachColValue);
						
					}
					ConfigData cdObj=new ConfigData();
					String testKey = row1.getCell(0).getStringCellValue();
					cdObj.setTestKey(row1.getCell(ConfigKeyMap.get("testName")).getStringCellValue());
					cdObj.setRunFlag(row1.getCell(ConfigKeyMap.get("runFlag")).getStringCellValue());
					System.out.println(cdObj.toString());
//					
				//			String testKey = row1.getCell(0).getStringCellValue();
				//			String runFlag = row1.getCell(1).getStringCellValue();
//					if((ConfigKeyMap.get("runFlag").equalsIgnoreCase("n")) 
//					{
//					TestData data = getTestDataByKey(testKey);
//						System.out.println(data.toString());
						//Note: get data from the Config map and print individual value like below
						System.out.println(cdObj.getRunFlag());
						//Note: get data from the map and print individual value like below
		//				System.out.println(data.getName());
		//				System.out.println(data.getEmail());
		//				System.out.println(data.getUname());
		//				System.out.println(data.getPassword());
//					}
				}
				
		}
		
	}
	
				
	public static TestData getTestDataByKey(String key) throws Exception {
		return tdMap.get(key);
	}
	

	public static void main(String[] args) throws Exception 
	{
		
		ExcelReadWithMap readob=new ExcelReadWithMap();
		readob.readExcel();
		generateTestDataMap();
		printTestDataBasedOnConfig();
		
	}

}