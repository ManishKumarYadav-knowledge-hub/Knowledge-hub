package com.utility;

import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static int timeout = 10;

	public static Properties elementProperties;
	static {
		elementProperties = PropertiesFileReader.getInstance().readProperties("data.properties");
	}

	public static void openBrowser(String browserType ) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "internetexplorer":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}
	}
	public static WebElement WaitElementVisible(WebDriver driver, By by) {
	    return new WebDriverWait(driver,10)
	        .until(ExpectedConditions.visibilityOfElementLocated((by)));
	}
	
	public static void navigateUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void windowmaximize() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	public static void RefreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAllBrowsers() {
		if(driver!=null){
		driver.quit();
		}else{
			System.out.println("Session is null");
		}
	}

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig("./BusinessHubProject/src/extent-config/extent-config.xml");
		
	}
	
	
	
	
	
}
