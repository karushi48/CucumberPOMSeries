package stepdefinitions;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private static String pagetitle;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://www.saucedemo.com/");
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginpage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginpage.enterPassword(password);
	}

	@Then("page title should be {string}")
	public void pape_title_should_be(String expectedLoginPageTitle) {
		pagetitle= loginpage.getLoginPageTitle();
		   System.out.println("login page title: " + pagetitle);
		Assert.assertTrue(pagetitle.contains(expectedLoginPageTitle));

	}

}
