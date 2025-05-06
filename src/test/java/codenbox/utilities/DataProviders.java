package codenbox.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="LoginData")
	public String[][] getData() {
		String path = ".//testData//LoginData.xlsx";
		//creating object of ExcelReader
		ExcelReader xlutil=new ExcelReader(path);
		int totalrows=xlutil.getRowCount("Sheet1");//total num of rows
		int totalcols=xlutil.getColumnCount("Sheet1");//total num of columns

		String data[][] =new String [totalrows-1][totalcols]; //create 2d object
		for (int rowNum=2; rowNum<=totalrows;rowNum++) {
			for (int colNum=0; colNum<totalcols; colNum++) {
				data[rowNum-2][colNum]=xlutil.getCellData("Sheet1", colNum, rowNum);
			}
		}
		return data; //returning 2D array
	}

//
//	public static void main(String[] args) {
//	    // Program logic here
//	String path = ".//testData//LoginData.xlsx";
//	//creating object of ExcelReader
//	ExcelReader xlutil=new ExcelReader(path);
//	int totalrows=xlutil.getRowCount("Sheet1");//total num of rows
//	System.out.println(totalrows);
//	int totalcols=xlutil.getColumnCount("Sheet1");//total num of columns
//	System.out.println(totalcols);
//
//
//}
}
