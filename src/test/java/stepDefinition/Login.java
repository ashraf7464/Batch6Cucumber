package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.BaseClass;

public class Login {

    LoginPage loginPage;

    @Given("browser is open and navigate to Base URL")
    public void browser_is_open_and_navigate_to_base_url(){

    }

    @Given("user navigate to login page")
    public void user_navigate_to_login_page() throws InterruptedException {
        loginPage = new LoginPage(BaseClass.getDriver());
        loginPage.goToLoginPage();
        Thread.sleep(1000);
    }
    @When("user enters valid {string}")
    public void user_enters_valid_username(String userName) {
//        WebElement userNamePath = driver.findElement(By.xpath("//input[@name='username-44']"));
//        userNamePath.sendKeys(userName);
        loginPage.enterUserName(userName);
    }
    @And("user enter a valid {string}")
    public void user_enter_a_valid_password(String password) {
//        WebElement passwordPath = driver.findElement(By.xpath("//input[@name='user_password-44']"));
//        passwordPath.sendKeys(password);
          loginPage.enterPassword(password);
    }
    @And("user click on Login")
    public void user_click_on_login() {

        loginPage.clickOnLogin();

    }
    @Then("Validate that user is on the Home Page")
    public void validate_that_user_is_on_the_home_page() {
        loginPage.validateUserOnHomePage();

    }
}
