package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {

	@Test
	public void writeExcel() throws Exception
	{
	String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
	
	FileInputStream fis=new FileInputStream(xlPath);
	//open workbook and sheet
	XSSFWorkbook wbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=wbook.getSheet("EmployeeDetails");
	
	//input values
	sheet.getRow(0).createCell(4).setCellValue("Result");
	sheet.getRow(1).createCell(4).setCellValue("Pass");
	
	sheet.getRow(1).getCell(4).setCellValue("Fail"); //change value of row 1 cell 4
	sheet.createRow(11).createCell(0).setCellValue("Danny");
	
	//write to excel
	FileOutputStream fos=new FileOutputStream(xlPath);
	wbook.write(fos);
	
	//close the file and all streams
	fos.close();
	wbook.close();
	fis.close();
	
	
	}
}
