package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AlertPage;
import utilities.BaseClass;

public class Alert {

    AlertPage alertPage;


    @Given("Open browser and navigate to Base URL")
    public void open_browser_and_navigate_to_base_url() {

    }

    @Given("user navigate to the practice page")
    public void user_navigate_to_the_practice_page() throws InterruptedException {
        alertPage = new AlertPage(BaseClass.getDriver());
        alertPage.goToPracticePage();
        Thread.sleep(2000);
    }
    @When("user click on Try It")
    public void user_click_on_try_it() {

        alertPage.clickOnTryIt();
    }
    @When("user validate Alert box is present")
    public void user_validate_alert_box_is_present() {

        alertPage.validateAlertBox();

    }
    @Then("User accept the alert")
    public void user_accept_the_alert() {

        alertPage.acceptAlert();
    }

    @Given("user navigates to practice page")
    public void user_navigates_to_practice_page() throws InterruptedException {

        alertPage = new AlertPage(BaseClass.getDriver());  //Why do we have to re-initiate
        alertPage.goToPracticePage();
        Thread.sleep(2000);

    }
    @When("user switch to iFrame")
    public void user_switch_to_i_frame() {
        alertPage.switchToIframe();
    }

    @When("user click on Practice page link")
    public void user_click_on_practice_page_link() {
        alertPage.clickOnIframePracticePage();
    }

}
