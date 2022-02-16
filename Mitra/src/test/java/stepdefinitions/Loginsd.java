package stepdefinitions;

import com.aventstack.extentreports.util.Assert;
import com.driver.Driverfactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginsd {
	private static String title;
	private LoginPage loginpage = new LoginPage(Driverfactory.getDriver());
	
	
	@Given("user navigates to KareHealth Login page")
	public void user_navigates_to_kare_health_login_page() {
	   Driverfactory.getDriver().get("http://karehealth.menpaniproducts.com/admin/auth/login");
	}

	@When("user  enter the Username {string}")
	public void user_enter_the_username(String username) {
		loginpage.enterUserName(username);
	    	
	}
	@When("user enter the password {string}")
	public void user_enter_the_password(String password) {
		loginpage.enterPassword(password);

	}
	

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginpage.clickOnLogin();
	}

	@Then("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
		title = loginpage.getLoginPageTitle();
		System.out.println("title of the page is" + title);
	}
	

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	}
}
