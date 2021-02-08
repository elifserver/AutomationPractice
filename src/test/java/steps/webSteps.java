package steps;

import com.framework.Pages.HomePage;

import com.framework.Pages.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.io.IOException;


public class webSteps {
    private static HomePage homePage = new HomePage();
    private static SignInPage signInPage = new SignInPage();


    @Given("User landed to Automation Practice home page")
    public void userLandedToAutomationPracticeHomePage() throws IOException {
        homePage.NavigateToHomePage();
    }

    @When("User clicks Signin")
    public void userClicksSignin() {
        homePage.clickSignIn();
    }

    @Then("User should get error on the page")
    public void userShouldGetErrorOnThePage() {
        System.out.println(signInPage.errorMessage.getText());
    }

    @When("User sends {string} and {string}")
    public void userSendsAnd(String email, String password) {
        signInPage.trySignInUsing(email, password);
    }

    @Then("User should get {string} on the page")
    public void userShouldGetOnThePage(String expectedErrorMessage) {
        Assert.assertEquals("Message is different than expected:: " +
                "Expected--> " + expectedErrorMessage +
                "Actual--> " + signInPage.GetErrorMessageScript(), signInPage.GetErrorMessageScript(), expectedErrorMessage);
    }
}
