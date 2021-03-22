package HybridModel.NoonAutomationFramework.qa.TestSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HybridModel.NoonAutomationFramework.qa.base.TestBase;
import HybridModel.NoonAutomationFramework.qa.pages.HomePage;
import HybridModel.NoonAutomationFramework.qa.pages.MobilePage;

public class MobileSearchTest extends TestBase{
	
	public MobileSearchTest() {
		super();
	}
	
	HomePage homepage;
	MobilePage mobilepage;
	
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
		mobilepage=new MobilePage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void mobilePageVerification1Test() {
		homepage.enterSearchItem(properties.getProperty("SearchBarText"));
		
		//System.out.println(mobilepage.resultText.getText());
		Assert.assertEquals(mobilepage.resultText.getText(), "\"Mobile Phones\"");
		
		//System.out.println(mobilepage.getPageTitle());
		Assert.assertEquals(mobilepage.getPageTitle(), "Shop online for Mobile Phones in Dubai, Abu Dhabi and all UAE");
	}
	

	

}
