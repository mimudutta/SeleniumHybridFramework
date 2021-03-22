package HybridModel.NoonAutomationFramework.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import HybridModel.NoonAutomationFramework.qa.base.TestBase;

public class MobilePage extends TestBase{
	
	public MobilePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH, using = "//div[@data-qa=\"searchHeader\"]/h1")
	public WebElement resultText;
	
	//Actions or Business Logic
	public String getPageTitle() {
		return driver.getTitle();
	}
		
		

}
