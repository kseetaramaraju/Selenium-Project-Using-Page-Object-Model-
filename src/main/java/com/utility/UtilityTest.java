package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class UtilityTest {

	//Workbook workbook;
	//FileInputStream fis;

	@Attachment(value ="Screenshot", type = "image/png")
	public byte[] takeScreenShotFailure(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
//
//	public Object[][] getDataFromSheet(String sheetName,String excelFilePath) {
//
//		try {
//			fis = new FileInputStream(excelFilePath);
//			workbook = new XSSFWorkbook(fis);
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		Sheet sheet = workbook.getSheet(sheetName);
//		int rowCount = sheet.getPhysicalNumberOfRows();
//		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
//		Object[][] data = new Object[rowCount - 1][colCount];
//
//		for (int i = 1; i < rowCount; i++) {
//			Row row = sheet.getRow(i);
//			for (int j = 0; j < colCount; j++) {
//				data[i - 1][j] =  row.getCell(j).toString();
//			}
//		}
//		return data;
//	}

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle style;

	public static int getRowCount(String filename,String sheetname) throws IOException {
		fi=new FileInputStream(filename);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		int rowcount= sheet.getLastRowNum();

		fi.close();
		wb.close();
		return rowcount;
	}

	public static int getColumnCount(String filename,String sheetname,int rownum) throws IOException {
		fi=new FileInputStream(filename);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		row=sheet.getRow(rownum);

		int cellNum=row.getLastCellNum();

		fi.close();
		wb.close();
		return cellNum;
	}

	public static String getCellData(String filename,String sheetname,int rownum,int cellnum) throws IOException {
		fi=new FileInputStream(filename);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		String data;
		try
		{
			data=cell.toString();
		}catch (Exception e){
			data="";
		}
		fi.close();
		wb.close();
		return data;
	}

	public static void setCellData(String filename,String sheetname,int rownum,int cellnum,String data) throws IOException {
		fi=new FileInputStream(filename);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.createCell(cellnum);

		fo=new FileOutputStream(filename);
		cell.setCellValue(data);
		wb.write(fo);

		fi.close();
		wb.close();
		fo.close();
	}

	public static void fillGreenColor(String filename,String sheetname,int rownum,int cellnum) throws IOException {
		fi=new FileInputStream(filename);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);

		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);

		fo=new FileOutputStream(filename);
		wb.write(fo);

		fi.close();
		wb.close();
		fo.close();
	}

	public static void fillRedColor(String filename,String sheetname,int rownum,int cellnum) throws IOException {
		fi=new FileInputStream(filename);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(cellnum);

		style=wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);

		fo=new FileOutputStream(filename);
		wb.write(fo);

		fi.close();
		wb.close();
		fo.close();
	}




//	public void closeWorkbook() {
//		try {
//			workbook.close();
//			fis.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
}
