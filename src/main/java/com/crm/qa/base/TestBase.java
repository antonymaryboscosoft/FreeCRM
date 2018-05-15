package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	



	public TestBase() {
		
			try {
				prop = new Properties();
				File file = new File("C:/Users/unit2a/git/test/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
				FileInputStream ip = new FileInputStream(file);
				
//			FileInputStream ip = new FileInputStream(System.getProperty("E:/anto/eclpslunapom/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties"));

				prop.load(ip);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:/anto/seleniumchrom/chromedriver.exe");	
			
			driver = new ChromeDriver(); 
		}
		/*else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		*/
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	
}
}
