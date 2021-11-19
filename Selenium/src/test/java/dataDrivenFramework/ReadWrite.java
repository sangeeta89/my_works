package dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWrite {
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;
	public FileInputStream input;
	public File newFile,createFile;
	
	public XSSFWorkbook workbook1;
	public XSSFSheet sheet1;
	public Row row1; public Cell cell1;

	
	public void createFile() throws IOException {
		

			newFile=new File("D:/File/CreatedFile.xls");
			workbook=new HSSFWorkbook();
			sheet =workbook.createSheet("ApachePoi");
			
			Object[][] sheetData= {
					{"DataDrivenFramework","Apache Poi","To read write data from external file"},
					{"DD Framework","Supports Selenium webdriver","Current version 3.14"},
					{"Apache Poi library","5.0 version","Maven dependency"},
			};
					
			
			int rowcount=0;
			for (Object[] iterator: sheetData) {
				HSSFRow row=sheet.createRow(++rowcount) ;
				int columnCount=0;
				
				for(Object field: iterator) {
					cell=row.createCell(++columnCount);
					 if (field instanceof String) {
		                    cell.setCellValue((String) field);
		                } else if (field instanceof Integer) {
		                    cell.setCellValue((Integer) field);
		                }
				}
			}
			
			 try (FileOutputStream outputStream = new FileOutputStream(newFile)) {
		            workbook.write(outputStream);
		        }
			 catch(Exception e) {System.out.println("exception occured "+e.getStackTrace());
			 }
			 
			 finally {
				 System.out.println("Finally new file create in location :"+ newFile);
			 }
		}

	
	public void MapUsage() {
		workbook1=new XSSFWorkbook();
		sheet1=workbook1.createSheet("Map ApachePoi");
		
		Map<String,Object[]> data=new TreeMap<String,Object[]>();
		data.put("1", new Object[]{"SNo","Framework","Version","Source"});
		data.put("2", new Object[]{1,"Selenium Webdriver","3.141","Maven"});
		data.put("3", new Object[]{2,"DataDriven","5.0","Maven"});
		data.put("4", new Object[]{3,"TestNG","6.8","Maven"});
//		XSSFCell formulaCell = sheet1.getRow(0).createCell(sheet1.getLastRowNum() + 1);
//		XSSFFormulaEvaluator formulaEvaluator =  workbook1.getCreationHelper().createFormulaEvaluator();
//				formulaEvaluator.evaluateFormulaCell(formulaCell);
	
		Set<String> entrykeys=data.keySet();
		
		int rownum=0;
		for (String key:entrykeys)
		{
				row1=sheet1.createRow(rownum++) ;
				Object[] objArr= data.get(key);
				
				int cellnum=0;
				for(Object obj:objArr) {
					cell1=row1.createCell(cellnum++);
					 if (obj instanceof String) {
		                    cell1.setCellValue((String) obj);
		                } else if (obj instanceof Integer) {
		                    cell1.setCellValue((Integer) obj);
		                }
				}
			}
		int rownum1=sheet1.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(rownum1);
		try {
			createFile=new File("D:/File/MapFile.xlsx");
			FileOutputStream outputStream = new FileOutputStream(createFile) ;
	        workbook1.write(outputStream);
	        outputStream.close();
	        
	        }
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Created xlsx file using Map in this path:"+createFile);
		}
	
}

	public static void main(String arg[]) throws IOException {
		ReadWrite instance=new ReadWrite();
		instance.createFile();
		instance.MapUsage();
	}

}
