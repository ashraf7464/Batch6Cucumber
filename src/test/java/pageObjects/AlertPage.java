package pageObjects;

import io.cucumber.java.it.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseClass;

import java.time.Duration;

public class AlertPage {

    public AlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Practice')]")
    WebElement practicePagePath;

    @FindBy(xpath = "//button[@class='onclick']")
    WebElement tryItButton;

    @FindBy(xpath = "//iframe[@src='https://uprightforum.tech']")
    WebElement iFrame;

    @FindBy(xpath = "//a[contains(text(),'Practice')]")
    WebElement iFramePracticePagePath;

    public void goToPracticePage(){

        practicePagePath.click();
    }

    public void clickOnTryIt(){

        tryItButton.click();
    }

    public void validateAlertBox(){
        WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        String alertMsg = BaseClass.getDriver().switchTo().alert().getText();
        if(alertMsg.contains("Hello")){ //Hello! I am an alert box!
            System.out.println("Alert box is present");
        } else{
            System.out.println("Alert box is not present");
        }
    }

    public void acceptAlert(){

        BaseClass.getDriver().switchTo().alert().accept();

    }

    public void switchToIframe(){

        BaseClass.getDriver().switchTo().frame(iFrame);
    }

    public void clickOnIframePracticePage(){

        iFramePracticePagePath.click();
    }

}
