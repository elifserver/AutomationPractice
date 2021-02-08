package com.framework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInPage extends Base {
    @FindBy(id = "email")
    public WebElement emailArea;

    @FindBy(id = "passwd")
    public WebElement passwordArea;

    @FindBy(id = "SubmitLogin")
    public WebElement submitButton;


    @FindBy(xpath = "//h1[@class='page-heading']/following-sibling::div[@class='alert alert-danger']//li")
    public WebElement errorMessage;


    public String GetErrorMessageScript() {
        //return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        return errorMessage.getText();
    }

    public void trySignInUsing(String email, String password) {
        emailArea.sendKeys(email);
        passwordArea.sendKeys(password);
        submitButton.click();
    }


}
