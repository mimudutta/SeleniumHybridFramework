package HybridModel.NoonAutomationFramework.qa.pages;


import org.openqa.selenium.support.PageFactory;

import HybridModel.NoonAutomationFramework.qa.base.TestBase;

public class LaptopsPage extends TestBase{
	
	public LaptopsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//say there is a form in this page. will use dataProvider and get data from excel in test case
	public void LaptopcontactsForm(String Fname, String Lname, String place, String phNo) {
		System.out.println(Fname+" "+Lname+" "+place+" "+phNo);
	}
}
