package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseClass;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='fas fa-user']")
    WebElement loginLinkPath;
    @FindBy(xpath = "//input[@name='username-44']")
    WebElement userNamePath;
    @FindBy(xpath = "//input[@name='user_password-44']")
    WebElement passwordPath;
    @FindBy(xpath = "//input[@id='um-submit-btn']")
    WebElement loginButton;
    @FindBy(xpath = "//a[contains(text(), 'Md Siddique')]")
    WebElement accountName;

    public void goToLoginPage(){
        loginLinkPath.click();
    }

    public void enterUserName(String userName){
        userNamePath.sendKeys(userName);
    }

    public void enterPassword(String password){
        passwordPath.sendKeys(password);
    }

    public void clickOnLogin(){
        loginButton.click();
    }

    public void validateUserOnHomePage(){
        String accountHolderName = accountName.getText();
        System.out.println("Account Holders Name: "+accountHolderName);
        if(accountHolderName.equalsIgnoreCase("Md Siddique")){
            System.out.println("Successfully logged in");
        } else{
            System.out.println("Login not successful");
        }

    }
}
