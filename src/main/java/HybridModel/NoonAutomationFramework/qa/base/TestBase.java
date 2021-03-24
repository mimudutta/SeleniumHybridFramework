package HybridModel.NoonAutomationFramework.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import HybridModel.NoonAutomationFramework.qa.utility.UtilLoadTime;
import HybridModel.NoonAutomationFramework.qa.utility.WebEventHandler;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	public static FileInputStream fis;
	public static EventFiringWebDriver e_driver;
	public static WebEventHandler eventListener;
	
	
	public TestBase() {
		
		try {
			properties=new Properties();
			fis=new FileInputStream("/Users/md/eclipse-workspace/NoonAutomationFramework/src/main/java/HybridModel/NoonAutomationFramework/qa/config/config.properties");
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
	        if (fis != null) {
	            try {
	                fis.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		}
}


	public static void initialization() {
		String browserName=properties.getProperty("browser");
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup(); 
			driver= new FirefoxDriver();		
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver= new ChromeDriver();		
		}
		else if(browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup(); 
			driver= new OperaDriver();		
		}
		
		e_driver=new EventFiringWebDriver(driver);
		//creating obj for WebEventHandler to register it with EventFiringWebDriver
		WebEventHandler eventListener = new WebEventHandler(); 
		e_driver.register(eventListener);
		driver=e_driver;
		
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilLoadTime.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilLoadTime.IMPLICITE_WAIT, TimeUnit.SECONDS);
		//driver.navigate().to(properties.getProperty("URL"));
		driver.get(properties.getProperty("URL"));	
	}
	
		

}












