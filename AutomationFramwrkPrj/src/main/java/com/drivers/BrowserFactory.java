package com.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserFactory {
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void selectbrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "/AutomationFramwrkPrj/src/main/resources/Drivers/chromedriver.exe");
	    driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "/AutomationFramwrkPrj/src/main/resources/Drivers/geckodriver.exe");
	    driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
		System.setProperty("webdriver.ie.driver", "/AutomationFramwrkPrj/src/main/resources/Drivers/IEDriverServer.exe");
	    driver= new InternetExplorerDriver();
		}
		
	}
	@Test
	public void launchbrowser() 
	{
	    driver.get("https://www.google.com");

	}
	@AfterTest
	public void closebrowser()
	{
		driver.quit();
	}
}
