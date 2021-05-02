package HybridModel.NoonAutomationFramework.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

	public String CONFIG_FILE_PATH_WIN="C:\\Users\\acer\\eclipse-workspace\\";
	public String CONFIG_FILE_PATH_MAC="/Users/md/eclipse-workspace/";
	public String CONFIG_FILE_PATH= CONFIG_FILE_PATH_MAC +
					"NoonAutomationFramework/src/main/java/HybridModel/NoonAutomationFramework/qa/config/config.properties";

	//public String propFilepath ="/Users/md/eclipse-workspace/NoonAutomationFramework/src/main/java/HybridModel/NoonAutomationFramework/qa/config/config.properties";

	
	
	public TestBase() {
		
		try {
			properties=new Properties();
			fis=new FileInputStream(CONFIG_FILE_PATH);
			fis=new FileInputStream(System.getProperty("user.dir")+
						"/src/main/java/HybridModel/NoonAutomationFramework/qa/config/config.properties");
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
			//System.setProperty("webdriver.geko.driver","//c:/Program/chrome");
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver= new ChromeDriver();		
		}
		else if(browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup(); 
			driver= new OperaDriver();		
		}
		else if(browserName.equalsIgnoreCase("Chromeheadless")) {
			WebDriverManager.chromedriver().setup(); 
			ChromeOptions options=new ChromeOptions();
			options.addArguments("window-size=1400,800");
			//options.setHeadless(true);     // user either this line or next line.
			options.addArguments("headless");
			driver= new ChromeDriver(options);		
		}
		
		else if(browserName.equalsIgnoreCase("firefoxheadless")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("window-size=1400,800");
			options.setHeadless(true); 
			driver= new FirefoxDriver();
		}	
			
		else if(browserName.equalsIgnoreCase("htmlunitdriver")) {
			WebDriverManager.firefoxdriver().setup();
			//driver=new HtmlUnitDriver();
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













