package excelMagic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoCellcompare 
{

	public static void main(String[] args) throws Exception 
	{
			FileInputStream f1 = new FileInputStream("E:\\Exceltest1.xlsx");
			XSSFWorkbook wb1 = new XSSFWorkbook(f1);
			XSSFSheet sh1 = wb1.getSheet("Sheet1");
			XSSFSheet sh2=wb1.getSheet("Sheet2");
			XSSFRow row=null,row1=null;
			XSSFCell cell=null,cell1=null;
	

			/*
 			Iterator<Row> rowIterator = sh1.iterator(); 
 
			
			while (rowIterator.hasNext()) 
			{ 
			row = (XSSFRow) rowIterator.next(); 
			//For each row, iterate through all the columns 
			Iterator<Cell> cellIterator = row.cellIterator(); 

			while (cellIterator.hasNext() ) 
			{ 
			cell = (XSSFCell) cellIterator.next(); 
			//Check the cell type and format accordingly 
			switch (cell.getCellType()) 
			{ 
			case Cell.CELL_TYPE_NUMERIC: 
			System.out.print(cell.getNumericCellValue() + "\t"); 
			break; 
			case Cell.CELL_TYPE_STRING: 
			System.out.print(cell.getStringCellValue() + "\t"); 
			break; 
			} 
			} 
			System.out.println(""); 
			} 
*/			
	
	}}

