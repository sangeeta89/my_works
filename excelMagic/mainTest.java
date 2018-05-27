/**
 * 
 */
package excelMagic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.examples.CreateCell;

import com.google.common.collect.Table.Cell;

/**
 * @author Sangeeta
 *
 */
public class mainTest {

	/**
	 * @param args
	 * 
	 */
	static int temp1,temp2;
	static String columnData;
	public static void main(String[] args) throws Exception{
		
		
			FileInputStream fi=new FileInputStream("E:\\testsuites\\TestSuite.xlsx");
			
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet sheet=wb.getSheet("runFlag");
			XSSFRow row=null;
			int rowcount,i,j;
			rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
			for (i=0;i<rowcount+1;i++)
			{

				row=sheet.getRow(i);
				System.out.println();
				
				for(j=0;j<row.getLastCellNum();j++)
				{	
					
					columnData=(row.getCell(j).getStringCellValue()+ "||");
					System.out.print(columnData);
					if(row.getCell(j).getStringCellValue().equals("Y"))
					{
						 XSSFCell c1 = row.createCell(j+1);
						 c1.setCellValue("Pass");
					
					
					}

				}
				
				System.out.println("\t");
				//Write a column "Result" at the end in same sheet

				row=sheet.getRow(0);
				row.createCell(3).setCellValue("Result");
			}
			
			fi.close();
 
			   FileOutputStream output = new FileOutputStream("E:\\testsuites\\TestSuite.xlsx");
			   
			   //write data in the excel file
			   wb.write(output);

			   //close output stream

			   output.close();
			   System.out.println("Data written successfully");
			}
			
		}
