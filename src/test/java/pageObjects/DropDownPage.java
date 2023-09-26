package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseClass;

public class DropDownPage {

    Select select;
    public DropDownPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Practice')]")
    WebElement practicePagePath;

    @FindBy(xpath = "//select[@class='form-control']")
    WebElement dropDown;

    public void goToPracticePage(){

        practicePagePath.click();
    }

    public void clickOnSelect(){
        dropDown.click();
    }

    public void selectOptionOne(){
        select = new Select(dropDown);
        select.selectByVisibleText("Option 1");
    }

    public void selectOptionTwo(){

        select.selectByVisibleText("Option 2");
    }

    public void selectOptionThree(){

        select.selectByVisibleText("Option 3");
    }

    public void validateDropDownSelect(){

        WebElement currentSelectedOption = select.getFirstSelectedOption();
        assert currentSelectedOption.getText().equals("Option 3");
        //or

        if(currentSelectedOption.getText().equalsIgnoreCase("Option 3")){
            System.out.println("Option 3 is currently selected");
        } else{
            System.out.println("Option 3 is not currently selected");
        }
    }
}
