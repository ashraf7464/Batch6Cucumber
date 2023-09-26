package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;
import utilities.CommonUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandlesPage {

    Set<String> windowHandles;
    //List<String> windowHandlesList;
    String firstWindowID;

    public WindowHandlesPage(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='openwindow']")
    WebElement openWindowButton;
    @FindBy(xpath = "//span[text()='info@qaclickacademy.com']")
    WebElement emailAddress;
    @FindBy(xpath = "//h1[contains (text(), 'Practice Page')]")
    WebElement practicePageTxt;

    public void clickOnWindowButton(){
        openWindowButton.click();

    }

    public void switchToNewWindow(){
        windowHandles = BaseClass.getDriver().getWindowHandles();
        System.out.println("Number of windows: "+windowHandles.size());
        firstWindowID = BaseClass.getDriver().getWindowHandle();

        for(String m:windowHandles){
            if(!m.equals(firstWindowID)){
                BaseClass.getDriver().switchTo().window(m);
            }

        }

        String emailTxt = emailAddress.getText();
        System.out.println(emailTxt);

//        windowHandlesList = new ArrayList<>(windowHandles);
//        BaseClass.getDriver().switchTo().window(windowHandlesList.get(1));
        System.out.println("New window url: "+BaseClass.getDriver().getCurrentUrl());
        System.out.println("New window ID: "+BaseClass.getDriver().getWindowHandle());
    }

    public void switchToFirstWindow() throws InterruptedException, IOException {
        BaseClass.getDriver().switchTo().window(firstWindowID);
        //BaseClass.getDriver().switchTo().window(windowHandlesList.get(0));
        String pageHeading = practicePageTxt.getText();
        System.out.println("Main heading of the page is: "+pageHeading);
        System.out.println("First window url: "+BaseClass.getDriver().getCurrentUrl());
        System.out.println("First window ID: "+BaseClass.getDriver().getWindowHandle());
        //CommonUtility.ScrollHeight();
        CommonUtility.screenshot("Test.png");
    }

















}
