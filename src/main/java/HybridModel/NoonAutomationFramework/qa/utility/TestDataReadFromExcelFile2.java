package HybridModel.NoonAutomationFramework.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;

public class TestDataReadFromExcelFile2 {
	
	public static String TESTDATA_SHEET_PATH = "/Users/md/eclipse-workspace/NoonAutomationFramework/src/main/java/HybridModel/NoonAutomationFramework/qa/testData/FreeCrmTestData.xlsx";

	static Workbook noonBook;
	static Sheet noonSheet;
	static JavascriptExecutor js;

	
	
	public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			noonBook = WorkbookFactory.create(file);   
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//suppose there are 4 rows in as sheet, then sheet.getLastRowNum() will return 4
		//and sheet.getRow(0).getLastCellNum() will return last column, say if 3 column, it will return 3
		noonSheet = noonBook.getSheet(sheetName);
		//System.out.println(noonSheet.getLastRowNum() + "--------" +
		//		 noonSheet.getRow(noonSheet.getLastRowNum()).getLastCellNum());
		Object[][] data = new Object[noonSheet.getLastRowNum()][noonSheet.getRow(0).getLastCellNum()];
		 
		
		
		//itterating in the matric, i=LastRows, k=LastColumns
		for (int i = 0; i < noonSheet.getLastRowNum(); i++) {
			for (int k = 0; k < noonSheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = noonSheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	}

}
