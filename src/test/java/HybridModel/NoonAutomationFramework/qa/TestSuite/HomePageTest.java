package HybridModel.NoonAutomationFramework.qa.TestSuite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HybridModel.NoonAutomationFramework.qa.base.TestBase;
import HybridModel.NoonAutomationFramework.qa.pages.ElectronicsPage;
import HybridModel.NoonAutomationFramework.qa.pages.HomePage;
import HybridModel.NoonAutomationFramework.qa.pages.MobilePage;

public class HomePageTest extends TestBase{
	
	public HomePageTest() {
		super();
	}
	
	HomePage homepage;
	MobilePage mobilepage;
	ElectronicsPage electoPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage=new HomePage();
		mobilepage=new MobilePage();
		electoPage=new ElectronicsPage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="")
	
	@Test
	public void electronicsPageListVerificationTest() {
		if(homepage.electronics_top.isDisplayed()) {
			homepage.electronics_top.click();
		}
		System.out.println(electoPage.getfeaturedCategoryList());
		System.out.println(electoPage.validatePageTitle());
		
		//System.out.println(mobilepage.resultText.getText());
		//Assert.assertEquals(mobilepage.resultText.getText(), "\"Mobile Phones\"");
		
		//System.out.println(mobilepage.getPageTitle());
		//Assert.assertEquals(mobilepage.getPageTitle(), "Shop online for Mobile Phones in Dubai, Abu Dhabi and all UAE");
	}
	
}
