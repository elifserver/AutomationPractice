package com.framework.Pages;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class HomePage extends Base {

    @FindBy(className = "login")
    public WebElement signInButton;


    public void NavigateToHomePage() throws IOException {
        driver.get(ReadFromGlobalProperties("WebBaseURL"));
    }

    public void clickSignIn() {
        signInButton.click();
    }


}
