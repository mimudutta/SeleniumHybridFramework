package HybridModel.NoonAutomationFramework.qa.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HybridModel.NoonAutomationFramework.qa.base.TestBase;

public class HomePage extends TestBase{
	
	WebDriverWait wait;
	
	
	//Initializing the Page Objects
	
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
	
	//PageFactory-ObjectRepository
	
	@FindBy(how=How.XPATH, using="//span[text()='Electronics']")
	public WebElement electronics;
	
	@FindBy(how = How.ID, using = "searchBar")
	public WebElement searchBarElement;
	
	@FindBy(how = How.XPATH, using = "//*[@id='btn_logo']/img")
	public WebElement noonLogo;
	
	@FindBy(how = How.XPATH, using = "//li[@data-qa=\"btn_main_menu_Electronics\"]/a/span")
	public WebElement electronics_top;


	
	
	
	//Actions or Business Logic
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePageLogo() {
		return noonLogo.isDisplayed();
	}
	
	public void enterSearchItem(String input) {
		wait= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(searchBarElement));
		searchBarElement.sendKeys(input);
		searchBarElement.sendKeys(Keys.RETURN);
	}
	
	
}
