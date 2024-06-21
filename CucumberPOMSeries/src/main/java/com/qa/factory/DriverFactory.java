package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver init(String browser) {
		System.out.println("browser value is :" + browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			tldriver.set(new ChromeDriver());
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}else if (browser.equals("safari")) {
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
		}else
		{
			System.out.println("Please pass browser" + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
		public static synchronized WebDriver getDriver()
		{
			return tldriver.get();
		}
		
	}
