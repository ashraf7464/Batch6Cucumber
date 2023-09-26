package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MouseHoverOverPage;
import utilities.BaseClass;

public class MouseHoverOver {

    MouseHoverOverPage mouseHoverOverPage;

    @Given("user opens browser and navigate to Practice Page")
    public void user_opens_browser_and_navigate_to_practice_page() throws InterruptedException {
        mouseHoverOverPage = new MouseHoverOverPage(BaseClass.getDriver());
        mouseHoverOverPage.goToPracticePage();
        Thread.sleep(2000);
    }

    @When("user hover the mouse over the Main Item Two")
    public void user_hover_the_mouse_over_the_main_item_two() throws InterruptedException {
        mouseHoverOverPage.hoverMouseOverMainItemTwo();
        Thread.sleep(2000);
    }

    @When("user hover the mouse over the Sub Sub List")
    public void user_hover_the_mouse_over_the_sub_sub_list() throws InterruptedException {
        mouseHoverOverPage.hoverMouseOverSubSubList();
        Thread.sleep(2000);
    }
    @Then("user can select Sub Sub Item One using Action Class")
    public void user_can_select_sub_sub_item_one_using_action_class() throws InterruptedException {
        mouseHoverOverPage.hoverMouseOverSubSubItemOne();
    }
    @Then("user validate Sub Sub Item is selected")
    public void user_validate_sub_sub_item_is_selected(){
        mouseHoverOverPage.validateFinalSelection();
    }

}
