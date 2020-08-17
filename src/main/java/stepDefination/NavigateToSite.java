package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;

import com.utility.Baseclass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigateToSite extends Baseclass {
	@Given("^Open site in \"(.*?)\"$")
	public void Open_site_in_browser(String browserName) {
		try {
			Baseclass.openBrowser(browserName);
		} catch (Exception e) {

		}
	}

	@When("^navigate to the site$")
	public void navigated_to_the_site() {
		try {
			driver.navigate().to(elementProperties.getProperty("url"));
			driver.manage().window().maximize();
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}

	@Then("^verify the home page title$")
	public void verify_the_home_page_title() {
		try {
			String pageTitle = driver.getTitle();
			Assert.assertEquals(pageTitle, elementProperties.getProperty("homepagetitle"));
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}

	@And("^click view all article button$")
	public void click_view_all_article_button() {
		try {
			Baseclass.WaitElementVisible(driver, By.xpath(elementProperties.getProperty("viewallarticle"))).click();
		} catch (StaleElementReferenceException | ElementNotInteractableException e) {
			e.printStackTrace();
		}
		
	}
	@And("^close all browser$")
	public void close_all_browser(){
		Baseclass.closeAllBrowsers();
	}
	
}
