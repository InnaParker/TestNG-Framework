package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDemo {
	
	@Test
	public void readExcel() throws IOException
	{
		String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
		FileInputStream fis=new FileInputStream(xlPath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("EmployeeDetails");
		
		//XSSFRow row=sheet.getRow(1);
		// Accessing 2nd row 4th column
		String value=sheet.getRow(1).getCell(3).toString();
		System.out.println(value);
		
		// Accessing 5th row and 1st column
		String value1=sheet.getRow(4).getCell(0).toString();
		System.out.println(value1);
		
		// How to find number of rows u to down
		int rowNum=sheet.getPhysicalNumberOfRows();
		
		// How to find number of cells
		int colNum=sheet.getRow(0).getLastCellNum();
		
		System.out.println(rowNum);
		System.out.println(colNum);
		
		// Retrieve all data from file
		for (int i=0; i<rowNum; i++) {
			
			for (int j=0; j<colNum; j++) {
				
				String cellValue=sheet.getRow(i).getCell(j).toString();
				System.out.print(cellValue+" ");
			}
			System.out.println();
		}
		workbook.close();
		fis.close();
		}

}
