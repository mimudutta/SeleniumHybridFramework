package HybridModel.NoonAutomationFramework.qa.TestSuite;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HybridModel.NoonAutomationFramework.qa.base.TestBase;
import HybridModel.NoonAutomationFramework.qa.pages.LaptopsPage;
import HybridModel.NoonAutomationFramework.qa.utility.TestDataReadFromExcelFile2;

public class LaptopsPageTest extends TestBase{
	
	public LaptopsPageTest() {
		super();
	}
	
	LaptopsPage lp=new LaptopsPage();;
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp=new LaptopsPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getDataExcel() throws InvalidFormatException {
		Object [][] data=TestDataReadFromExcelFile2.getTestData("contacts");
		
		return data;
	}
	
	@Test(dataProvider="getDataExcel")
	public void dataProviderTest(String s1, String s2,String s3,String s4) {  //say 4 columns are there
		lp.LaptopcontactsForm(s1, s2, s3, s4);
		
	}

}
