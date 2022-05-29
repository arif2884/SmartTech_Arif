package com.utilitiespack;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	@SuppressWarnings({ "incomplete-switch", "resource" })
	public static void main(String[] args) throws Exception {
		
		FileInputStream file = new FileInputStream("./ExcelData/Students.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		for(int r=0; r<=rows; r++) {
			XSSFRow row = sheet.getRow(r);			
			
			for(int c=0; c<cols; c++) {
				
				XSSFCell cell = row.getCell(c);
				switch(cell.getCellType()) {
				
				case STRING:
					System.out.print(cell.getStringCellValue()); break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue()); break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue()); break;
				}
				System.out.print(" | ");
				
			}
			System.out.println();
		}

	}

}
