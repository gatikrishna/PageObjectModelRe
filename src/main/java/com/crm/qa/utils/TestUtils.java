package com.crm.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;

import com.crm.qa.base.TestBase;

public class TestUtils extends TestBase{

	private static String filePath = "D:\\Eclipse Workspace\\FreeCRMTest\\src\\main\\"
			+ "java\\com\\crm\\qa\\testdata\\CRMData.xlsx";
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String StrSheet) throws IOException {
		FileInputStream file = null;
		Workbook book = null;
		try {
			file = new FileInputStream(filePath);			
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		try {			
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException ife) {
			ife.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet = book.getSheet(StrSheet);
		
		int lastRow = sheet.getLastRowNum();
		int lastCol = sheet.getRow(0).getLastCellNum();
		Object data[][]= new Object[lastRow][lastCol];
		
		for (int row = 0;row<lastRow;row++) {
			for(int col=0;col<lastCol;col++) {
				data[row][col]=sheet.getRow(row+1).getCell(col).toString();
			}
		}
		
		return data;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
