package excelMagic;
/**
 * 
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Sangeeta
 * @param <readExcel>
 * @param <Map>
 *
 */
public class ReadExcelWithHashMap{

	/**
	 * @param args
	 */
	
	public static HSSFWorkbook mybook;
	public static HSSFSheet sheet1,sheet2;
	public static FileInputStream fis; public static HSSFCell cell1;
	public static HSSFRow row1,row2;
	public static HSSFCell cell;
//	public static int sheet1totalRows,sheet2totalRows,sh1eachRowValue,sh2eachRowValue,sh1eachColValue,sh2eachColValue;
	public static String sh1columnData;
	public static String sh2columnData;
//	public static HashMap<String, HashMap<String,String>> supermap=new HashMap<String, HashMap<String,String>>();
//	public static HashMap<String, String> hashmap=new HashMap<String, String>();
	//Note: map should be created as key(string/id) and value (object)
	public static HashMap<String, TestData> tdMap=new HashMap<String, TestData>();
	public static HashMap<String, Integer> tdKeyMap=new HashMap<String, Integer>();
	public static String sheet1keycell,sheet1value,sheet2keycell,sheet2value;
	
	public void readExcel() throws Exception{
		fis=new FileInputStream("D:\\myexcel.xls");
		mybook=new HSSFWorkbook(fis);
		sheet1=mybook.getSheet("Config");
		sheet2=mybook.getSheet("TestData");
	}
	
	public static void generateTestDataMap() {
		int sheet2totalRows, sh2eachRowValue, sh2eachColValue;
		sheet2totalRows=  sheet2.getLastRowNum() - sheet2.getFirstRowNum();
		for (sh2eachRowValue=0;sh2eachRowValue<=sheet2totalRows;sh2eachRowValue++) 
		{
			row2=sheet2.getRow(sh2eachRowValue);
			if ( sh2eachRowValue == 0) {
				for(sh2eachColValue=0;sh2eachColValue<row2.getLastCellNum();sh2eachColValue++) {
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
	
	public static void printTestDataBasedOnConfig() throws Exception
	{	
		
		System.out.println("Sheet1");
		int sheet1totalRows, sh1eachRowValue, sh1eachColValue;
		sheet1totalRows= sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		
		for (sh1eachRowValue=1; sh1eachRowValue<=sheet1totalRows;sh1eachRowValue++) {
			row1=sheet1.getRow(sh1eachRowValue);
			String testKey = row1.getCell(0).getStringCellValue();
			String runFlag = row1.getCell(1).getStringCellValue();
			if (runFlag.equalsIgnoreCase("n")) 
			{
				TestData data = getTestDataByKey(testKey);
				System.out.println(data.toString());
				//Note: get data from the map and print individual value like below
//				System.out.println(data.getName());
//				System.out.println(data.getEmail());
//				System.out.println(data.getUname());
//				System.out.println(data.getPassword());
			}
		}
		System.out.println("\n=================");
	}
	
	public static TestData getTestDataByKey(String key) throws Exception {
		return tdMap.get(key);
	}
	
//	public static HashMap<String, HashMap<String,String>> getConfigDataMap() throws Exception
//	{	
//		
//		System.out.print("Sheet1");
//		sheet1totalRows= sheet1.getLastRowNum()-sheet1.getFirstRowNum();
//		
//		for (sh1eachRowValue=0; sh1eachRowValue<sheet1totalRows;sh1eachRowValue++)
//		{
//			row1=sheet1.getRow(sh1eachRowValue);
//			System.out.println();
//			sheet1keycell=row1.getCell(0).getStringCellValue();
//			for(sh1eachColValue=0;sh1eachColValue<row1.getLastCellNum();sh1eachColValue++)
//			{	
//				sheet1value=(row1.getCell(sh1eachColValue).getStringCellValue()+ "\t");
//				System.out.print(sheet1value);
//				hashmap.put(sheet1keycell, sheet1value);
//			}
//			
//			
//		}
//		System.out.println("\n=================");
//		return supermap;
//	}
//	public static HashMap<String, HashMap<String,String>> getTestDataMap() throws Exception
//	{
//		System.out.print("\nSheet2");
//		System.out.println("\n======================================================");
//		sheet2totalRows=  sheet2.getLastRowNum()-sheet2.getFirstRowNum();
//
//		for (sh2eachRowValue=0;sh2eachRowValue<sheet2totalRows+1;sh2eachRowValue++)
//		{
//
//			row2=sheet2.getRow(sh2eachRowValue);
//			System.out.println();
//			sheet2keycell=row2.getCell(0).getStringCellValue();
//			
//			for(sh2eachColValue=0;sh2eachColValue<row2.getLastCellNum();sh2eachColValue++)
//			{	
//				
//				sheet2value=(row2.getCell(sh2eachColValue).getStringCellValue()+ "\t");
//				System.out.print(sheet2value);
//				hashmap.put(sheet2keycell, sheet2value);
////				
////				if (sheet1keycell.equals
////				{
////					System.out.println("matched");
////					System.out.println(hashmap.put(sheet2keycell, sheet2value));
////				
////				}
//			}
//			
//		}
//		
//		System.out.println("\n======================================================");
//		fis.close();
//		return supermap;
//	}
//	public static String getValue(String key) throws Exception
//	{
//		hashmap=new HashMap<>();
//		String returnVal=hashmap.get(key);
//		return returnVal;
//		
//	}
//	public static String compareData(String keys) throws Exception {
//		return keys;
//	}
	public static void main(String[] args) throws Exception 
	{
		
		ReadExcelWithHashMap readob=new ReadExcelWithHashMap();
		readob.readExcel();
//		readob.getConfigDataMap();
//		readob.getTestDataMap1();
		generateTestDataMap();
		printTestDataBasedOnConfig();
		
	}

}
