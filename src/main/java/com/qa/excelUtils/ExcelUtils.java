package com.qa.excelUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {
	public WebDriver driver;
	public String getRowData;
	public String getColData;
	public FileInputStream fis;
	public Workbook wb ;
	DataFormatter df;

	public void readExcel() throws EncryptedDocumentException, IOException, InvalidFormatException{
		DataFormatter df = new DataFormatter();
		FileInputStream fis= new FileInputStream("data1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int rows=sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			
		
		int col= sh.getRow(i).getLastCellNum();
		for (int j = 0; j < col; j++) {
			
			Cell c= sh.getRow(i).getCell(j);
			String value =df.formatCellValue(c);
			System.out.print(value+"  ");
		}
		System.out.println();
		}
	}
	
	public String readCell(int row, int col)throws Exception{
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("data1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Cell c= sh.getRow(row).getCell(col);
		return df.formatCellValue(c);
	}
	
	public void writeCell(int row, int col,String text) throws Exception{
		FileInputStream fis = new FileInputStream("data1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		sh.getRow(row).createCell(col).setCellValue(text);
		FileOutputStream fos = new FileOutputStream("data1.xlsx");
		wb.write(fos);
		fos.close();
		}
	
	public List<String> readAnyRowFromExel(String filePath, String sheetName, int rowNum) {
		ArrayList<String> expData = new ArrayList<String>();
		df = new DataFormatter();
		try {
			fis = new FileInputStream(filePath);// "courses.xlsx"
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheetName);// "User list"
		int cols = sh.getRow(rowNum).getLastCellNum();// 8
		System.out.println("Total colums are " + cols);// 8
		for (int j = 0; j < cols; j++) {
			Cell c = sh.getRow(rowNum).getCell(j);
			// System.out.println(c);
			getRowData = df.formatCellValue(c);
			expData.add(getRowData);
		}
		return expData;
	}

	public List<String> readAnyColumnFromExcel(String filePath, String sheetName, int colNumber) {
		ArrayList<String> expData = new ArrayList<String>();
		df = new DataFormatter();
		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet(sheetName);
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			Cell c = sh.getRow(i).getCell(colNumber);
			getColData = df.formatCellValue(c);
			expData.add(getColData);
		}
		//System.out.print(expData + "  ");
		return expData;
	}

}
