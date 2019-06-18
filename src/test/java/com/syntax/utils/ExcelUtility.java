package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	
	/**
	 * Method that will open specified xlFile and sheet
	 * @param xlFilePath
	 * @param sheetName
	 */
	public void openExcel(String xlFilePath, String sheetName)
	{
		try {
			fis=new FileInputStream(xlFilePath);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method will return string value of specified cell
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */
	public String getCellData(int rowIndex, int cellIndex)
	{
		return sheet.getRow(rowIndex).getCell(cellIndex).toString();
	}
	
	/**
	 * Method will return number of actual used rows
	 * @return int
	 */
	public int getRowNum()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	
	/**
	 * Method will return number of last columns
	 * @param rowIndex
	 * @return
	 */
	public int getColNum(int rowIndex)
	{
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	

}
