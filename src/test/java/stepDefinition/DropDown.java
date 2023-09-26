package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DropDownPage;
import utilities.BaseClass;

public class DropDown {

    DropDownPage dropDownPage;

    @Given("browser is open and navigate to the Base URL")
    public void browser_is_open_and_navigate_to_the_base_url() {

    }

    @Given("user navigate to practice page")
    public void user_navigate_to_practice_page() throws InterruptedException {
        dropDownPage = new DropDownPage(BaseClass.getDriver());
        dropDownPage.goToPracticePage();
        Thread.sleep(2000);
    }
    @When("user click on Select an option")
    public void user_click_on_select_an_option() throws InterruptedException {
        dropDownPage.clickOnSelect();
        Thread.sleep(1000);
    }

    @When("user select option One")
    public void user_select_option_one() throws InterruptedException {
        dropDownPage.selectOptionOne();
        Thread.sleep(1000);
    }

    @When("user select option Two")
    public void user_select_option_two() throws InterruptedException {
        dropDownPage.selectOptionTwo();
        Thread.sleep(1000);
    }

    @When("user select option Three")
    public void user_select_option_three() throws InterruptedException {
        dropDownPage.selectOptionThree();
        Thread.sleep(1000);
    }

    @Then("Validate Option Three is selected")
    public void validate_option_three_is_selected() {
        dropDownPage.validateDropDownSelect();
    }
}
