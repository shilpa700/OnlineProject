package com.qa.Base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public	static WebDriver driver;
	 public   static Properties prop;
		public TestBase(){
			
			try{
				prop=new Properties();
				FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config.properties");
				prop.load(ip);
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}
		public static void initialization(){
			String browserName= prop.getProperty("browser");
			if(browserName.equals("chrome")){
				  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				  WebDriver driver=new ChromeDriver();
			}
			
			else if(browserName.equals("firefox")){
				  System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				  WebDriver driver=new FirefoxDriver();
			
			}
			
			driver.manage().window().maximize();;
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(TestUtilClass.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtilClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
		
		


}
