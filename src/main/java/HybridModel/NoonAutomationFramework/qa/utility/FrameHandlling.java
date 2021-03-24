package HybridModel.NoonAutomationFramework.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import HybridModel.NoonAutomationFramework.qa.base.TestBase;

public class FrameHandlling extends TestBase{

	
	
	//===================For handeling iframes=======================
	public void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public void switchToFrame(WebElement locator) {
		driver.switchTo().frame(locator);
	}
	
	public void switchTodefaultContent(WebElement locator) {
		driver.switchTo().defaultContent();
	}
	
	
	/*
	 * Suppose if there are 100 frames in the page, and there is no ID available, in
	 * this case, we just don't know from which iframe required element is being
	 * loaded (It is the case when we do not know the index of the frame also).
	 * So use this IndexOfIframe() method to know the index.
	 */
	public void IndexOfIframe() {
		int size = driver.findElements(By.tagName("iframe")).size();

	    for(int i=0; i<=size; i++){
		driver.switchTo().frame(i);
		int total=driver.findElements(By.xpath("html/body/a/img")).size();
		System.out.println(total);
	    driver.switchTo().defaultContent();
	    }
	}
}
