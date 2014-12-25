package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {
	
	private static XSSFSheet ExcelSheet ;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell ExcelCell;
	private static XSSFRow excellRow;
	
	public static void setExcelFile(String path, String SheetName){
		
		try {
			FileInputStream excelFile = new FileInputStream(path);
			
			ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelSheet = ExcelWBook.getSheet(SheetName);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

	public static String getCellData(int RowNum, int ColNum){
		try {
			
			ExcelCell = ExcelSheet.getRow(RowNum).getCell(ColNum);
			String cellData = ExcelCell.getStringCellValue();
			return cellData;
			
		} catch (Exception e) {
		
			return "";
		}	
	}
	
	public static void setCellData(String Result, int RowNum, int ColNum){
	

		
		try {
			excellRow = ExcelSheet.getRow(RowNum);
			ExcelCell = excellRow.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if(ExcelCell==null){
				
				ExcelCell=excellRow.createCell(ColNum);
				ExcelCell.setCellValue(Result);
			}else {
				
				ExcelCell.setCellValue(Result);
				
			}
			
			FileOutputStream fileOut=new FileOutputStream(Constant.EXCELPATH+Constant.EXCELFILE);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
}
