package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.WindowHandlesPage;
import utilities.BaseClass;

import java.io.IOException;

public class WindowHandles {

    WindowHandlesPage windowHandlesPage;

    @Given("user is in the Practice Page")
    public void user_is_in_the_practice_page() {

    }

    @When("user click on the Open Window button")
    public void user_click_on_the_open_window_button() {
        windowHandlesPage = new WindowHandlesPage(BaseClass.getDriver());
        windowHandlesPage.clickOnWindowButton();
    }

    @Then("validate that user can switch to the second window")
    public void validate_that_user_can_switch_to_the_second_window() {
        windowHandlesPage.switchToNewWindow();
    }

    @Then("validate that user can switch to first window")
    public void validate_that_user_can_switch_to_first_window() throws InterruptedException, IOException {
        windowHandlesPage.switchToFirstWindow();


    }

}
