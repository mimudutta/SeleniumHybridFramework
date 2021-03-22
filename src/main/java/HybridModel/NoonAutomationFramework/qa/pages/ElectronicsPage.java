package HybridModel.NoonAutomationFramework.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import HybridModel.NoonAutomationFramework.qa.base.TestBase;

public class ElectronicsPage extends TestBase{
	
	//Initializing the Page Objects
	
		public ElectronicsPage() {
			PageFactory.initElements(driver, this);
		}
	
	
	//PageFactory-ObjectRepository
	
	@FindBy(xpath = "//a[@href='/uae-en/mobiles']/div/div/div/img")
	public WebElement mobileLogo;
	
	@FindBy(how = How.XPATH, using ="//div/p[contains(text(),'Featured Categories')]/ul[@class=\"qtg79b-4 gqguPq\"]" )
	private List<WebElement> featuredCategoryLeft;
	
	public List<String> getfeaturedCategoryList(){
		List<String> labelslist =new ArrayList<>();    //create an empty list in which the label texts will be stored
			for(WebElement we: featuredCategoryLeft) {
				labelslist.add(we.getText());          //add each webElements label to the labelsList
				System.out.println(labelslist);
			}
		
		return labelslist;
		
	}
	
	//*********************Important Xpath*************************
	//div[@class="qtg79b-2 ghBbL"]/child::ul/child::li/a[text()='Mobiles']----->help of parent to child if multiple child are present.
	//a[text()='Software']/parent::*/preceding-sibling::li/child::a[text()='Mobiles'] -----> with the help of other siblings for same parent
	
	//img[@class="sc-crrsfI iDhzRL" and @alt="/apple"] -------> Shop by Brand, Apple Logo
	////div[@class="productContainer"]/child::a[@id="productBox-N22732308A"]/div[contains(@title,"Apple AirPods")]---Apple page
	
	
	/*------ Axes names/methods -------
	👉 ancestor
	👉 ancestor-or-self
	👉 descendant
	👉 descendant-or-self
	👉 preceding-sibling
	👉 following-sibling
	👉 parent
	👉 child
	👉 following
	👉 preceding
	
	------ Examples ------
	//label[text()='Email']/following-sibling::input[1]
	//td[text()='Maria Anders']/preceding-sibling::td/child::input
	//label[text()='Email']/following-sibling::input[1]/parent::div
	//div[@class='container']/child::input[@type='text']
	//div[@class='container']/descendant::button
	//div[@class='buttons']/ancestor-or-self::div
	//label[text()='Password']/following::input[1]
	*/	
	@FindBy(xpath = "//div[@class=\"qtg79b-2 ghBbL\"]/child::ul/child::li/a[text()='Mobiles']")
	public WebElement mobileLeftLink;
	
	
	//Actions or Business Logic
	
	public String validatePageTitle() {
		return driver.getTitle();
	}

	

}
