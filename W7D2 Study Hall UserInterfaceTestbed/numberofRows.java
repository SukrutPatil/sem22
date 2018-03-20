package Example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFPivotTable;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class project1 {


public static void main(String args[]) throws Exception
{
	FileInputStream fis = new FileInputStream("C:\\Users\\Me\\Desktop\\SEM2\\WEEK10\\AD\\170026_B_AppDev_W10_EffortLogger.xlsm");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Individual Effort Logger");
	int sheet1 = workbook.getNumberOfSheets();
	System.out.println("Total number of sheets are: "+ " "+ sheet1);
	String worksheetName = workbook.getSheetName(workbook.getActiveSheetIndex());
	System.out.println( "Name of the Active Sheet is: " +" "+ worksheetName);
	XSSFRow row = sheet.getRow(10);
	int cellNum = row.getLastCellNum();
	System.out.println("Number of columns in row :"+"  " + cellNum);
	int rowNum = sheet.getLastRowNum();
	System.out.println("Total number of rows in a sheet:" + " " + rowNum);
	System.out.println("\n**************************************************\n");
 
    Iterator<Row> iterator = sheet.iterator();
    while(iterator.hasNext()) {
    	Row nextRow = iterator.next();
    	Iterator<Cell> cellIterator = nextRow.cellIterator();
    	 while (cellIterator.hasNext()) {
             Cell cell = cellIterator.next();
              
             switch (cell.getCellType()) {
                 case Cell.CELL_TYPE_STRING:
                     System.out.print(cell.getStringCellValue());
                     break;
                 case Cell.CELL_TYPE_BOOLEAN:
                     System.out.print(cell.getBooleanCellValue());
                     break;
                 case Cell.CELL_TYPE_NUMERIC:
                     System.out.print(cell.getNumericCellValue());
                     break;
             } 
          
         }
         System.out.println();
     }
      
     workbook.close();
     fis.close();
}

}

  
