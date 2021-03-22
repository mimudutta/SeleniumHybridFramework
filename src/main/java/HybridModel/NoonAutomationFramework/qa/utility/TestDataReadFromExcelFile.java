package HybridModel.NoonAutomationFramework.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataReadFromExcelFile {

    public void readExcel(String filePath,String fileName,String sheetName) throws IOException{

    File file =    new File(filePath+"\\"+fileName);  //Create an object of File class to open xlsx file
    FileInputStream inputStream = new FileInputStream(file);  //Create an object of FileInputStream class to read excel file

    Workbook NoonWorkbook = null;

    String fileExtensionName = fileName.substring(fileName.indexOf("."));  //Find the file extension by splitting file name in substring  and getting only extension name

	    if(fileExtensionName.equals(".xlsx")){  //Check condition if the file is xlsx file
	    	NoonWorkbook = new XSSFWorkbook(inputStream);   //If it is xlsx file then create object of XSSFWorkbook class
	    	}

	    else if(fileExtensionName.equals(".xls")){  //Check condition if the file is xls file
	    	NoonWorkbook = new HSSFWorkbook(inputStream);  //If it is xls file then create object of HSSFWorkbook class
	    	}

    Sheet NoonSheet = NoonWorkbook.getSheet(sheetName); //Read sheet inside the workbook by its name
    int rowCount = NoonSheet.getLastRowNum()-NoonSheet.getFirstRowNum();  //Find number of rows in excel file

    for (int i = 0; i < rowCount+1; i++) {  					//Create a loop over all the rows of excel file to read it
        Row row = NoonSheet.getRow(i);    					//Create a loop to print cell values in a row
        for (int j = 0; j < row.getLastCellNum(); j++) {  		//Print Excel data in console
            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
        }

        System.out.println();
    } 

    }  
    
    

    public static void main(String...strings) throws IOException{    //Main function is calling readExcel function to read data from excel file
    	TestDataReadFromExcelFile objExcelFile = new TestDataReadFromExcelFile();   //Create an object of TestDataReadFromExcelFile class
    	String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\HybridModel\\NoonAutomationFramework\\qa\\testData";     //Prepare the path of excel file
    	objExcelFile.readExcel(filePath,"NoonTestDataExcel.xlsx","HomePage");					//Call read file method of the class to read data
    }

}
