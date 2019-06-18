package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {

	@Test
	public void excelTest()
	{
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");
		
		//String value = obj.getCellData(2, 3);
		//System.out.println(value);
		
		//Retrieve all values from Excel and store into DataProvider (2D array object)
		int row=obj.getRowNum();
		int cell=obj.getColNum(0);
		
		Object[][] data=new Object[row][cell];
		//1st way
		//obj.getCellData(0, 0);
		//obj.getCellData(0, 1);
		
		//2nd better way loop thru each row & column
		for (int i=0; i<row; i++) {
			for (int y=0; y<cell; y++) {
				//Retrieve values from Excel
				String value=obj.getCellData(i, y);
				//Store values inside 2D array
				data[i][y]=value;
			}
		}
		System.out.println(data.length);
		
	}
}
