package com.euromsgexpress.stepDefinitions;

import com.euromsgexpress.pages.HomePage;
import com.euromsgexpress.pages.LoginPage;
import com.euromsgexpress.utilities.BrowserUtils;
import com.euromsgexpress.utilities.ConfigurationReader;
import com.euromsgexpress.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.*;

public class Login_defs {

    JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
    //
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("Navigate to home page")
    public void navigateToHomePage() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForClickability(loginPage.entryButton,7);
        loginPage.entryButton.click();
        BrowserUtils.waitForClickability(loginPage.emailBox,7);
    }


    @When("Send valid email and password")
    public void sendValidEmailAndPassword() {
        loginPage.emailBox.sendKeys("erencengel@gmail.com");
        loginPage.passwordBox.sendKeys("Ec.06050425");
    }

    @And("Proceed to captcha and click login button")
    public void proceedToCaptchaAndClickLoginButton() throws InterruptedException {
        Thread.sleep(40000);
        loginPage.loginButton.click();
    }

    @Then("Verify that user is on the home page")
    public void verifyThatUserIsOnTheHomePage() {
        BrowserUtils.waitForClickability(homePage.addToYourMembers,7);
        String expectedUrl = "https://console.euromsg.com/home";
        String actualUrl = Driver.get().getCurrentUrl();
        assertEquals(expectedUrl,actualUrl);
    }

    @When("Send invalid {string} and {string}")
    public void sendInvalidAnd(String email, String password) {
        loginPage.emailBox.sendKeys(email);
        loginPage.passwordBox.sendKeys(password);
    }

    @Then("Verify that user can not login")
    public void verifyThatUserCanNotLogin() throws InterruptedException {
        Thread.sleep(3000);
        String homePageUrl = "https://console.euromsg.com/home";
        assertFalse(Driver.get().getCurrentUrl().equals(homePageUrl));
    }

    @When("Click the email button and leave it blank")
    public void clickTheEmailButtonAndLeaveItBlank() {
        loginPage.emailBox.click();
    }

    @And("Click the password button")
    public void clickThePasswordButton() {
        loginPage.passwordBox.click();
    }

    @Then("Verify that warning is seen under email tab")
    public void verifyThatWarningIsSeenUnderEmailTab() {
        String expectedExpression = "This field is required.";
        String actualExpression = loginPage.emailBoxWarning.getText();
        assertEquals(expectedExpression,actualExpression);
    }

    @When("Sends a space String to the password button")
    public void sendsASpaceStringToThePasswordButton() {
        loginPage.passwordBox.sendKeys("");
    }

    @And("Click the email button")
    public void clickTheEmailButton() {
        loginPage.emailBox.click();
        loginPage.passwordBox.click();
    }

    @Then("Verify that warning is seen under password tab")
    public void verifyThatWarningIsSeenUnderPasswordTab() {
        String expectedExpression = "This field is required.";
        String actualExpression = loginPage.passwordBoxWarning.getText();
        assertEquals(expectedExpression,actualExpression);
    }


    @When("Click ForgetMyPassword bar")
    public void clickForgetMyPasswordBar() {
        loginPage.forgotPasswordButton.click();
    }

    @And("Send a valid email as {string} and verify captcha step")
    public void sendAValidEmailAsAndVerifyCaptchaStep(String email) throws InterruptedException {
        loginPage.emailBoxForNewPassword.sendKeys(email);
        Thread.sleep(40000);
    }

    @And("Click send button")
    public void clickSendButton() {
        loginPage.sendButton.click();
    }


    @Then("Verify that email is successfully sent")
    public void verifyThatEmailIsSuccessfullySent() {
        String expectedText = "The necessary information to reset your password has been successfully sent to your e-mail address.";
        String actualText = loginPage.resetMessageVerification.getText();
        assertEquals(expectedText,actualText);
    }
}


