package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

public class MouseHoverOverPage {

    Actions action;
    public MouseHoverOverPage(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//a[contains(text(),'Main Item 2')]")
    WebElement mainItem2;
    @FindBy(xpath = "//a[contains(text(), 'SUB SUB LIST')]")
    WebElement subSubList;
    @FindBy(xpath = "//a[contains(text(), 'Sub Sub Item 1')]")
    WebElement subSubItem1;

    String practicePage = "https://demoqa.com/menu#";

    public void goToPracticePage(){

        BaseClass.getDriver().get(practicePage);
    }

    public void hoverMouseOverMainItemTwo(){
        action = new Actions(BaseClass.getDriver());
        action.moveToElement(mainItem2).build().perform();
    }

    public void hoverMouseOverSubSubList(){
        action.moveToElement(subSubList).build().perform();
    }

    public void hoverMouseOverSubSubItemOne(){
        action.moveToElement(subSubItem1).build().perform();
        subSubItem1.click();
    }

    public void validateFinalSelection(){
        if(subSubItem1.isDisplayed()){
            System.out.println("Sub Sub Item 1 is selected");
        } else{
            System.out.println("Sub Sub Item 1 is not selected");
        }
    }
}
