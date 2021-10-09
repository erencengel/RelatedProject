package com.euromsgexpress.stepDefinitions;

import com.euromsgexpress.pages.AddmemberPage;
import com.euromsgexpress.pages.HomePage;
import com.euromsgexpress.pages.ListPage;
import com.euromsgexpress.utilities.BrowserUtils;
import com.euromsgexpress.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class Membership_defs {
    //
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.get();
    Faker faker = new Faker();
    //
    HomePage homePage = new HomePage();
    ListPage listPage = new ListPage();
    AddmemberPage addmemberPage = new AddmemberPage();

    @When("Click Üyelerini Ekle bar")
    public void clickÜyeleriniEkleBar() {
        homePage.addToYourMembers.click();
    }

    @And("Click Yeni Liste Oluştur bar")
    public void clickYeniListeOluşturBar() {
        BrowserUtils.waitForClickability(listPage.createNewList,7);
        listPage.createNewList.click();
    }

    String list;
    @And("Name the list")
    public void nameTheList() {
        BrowserUtils.waitForClickability(listPage.nameTheList,7);
        list = faker.company().name();
        listPage.nameTheList.sendKeys(list);
        listPage.saveBar.click();
    }

    String expectedName;
    String expectedSurname;
    String expectedEmail;
    @And("Add new member using add with form")
    public void addNewMemberUsingAddWithForm() {
        listPage.addMember.click();
        listPage.addMemberWithForm.click();
        expectedName = faker.name().firstName();
        expectedSurname = faker.name().lastName();
        expectedEmail = expectedName.toLowerCase() + "." + expectedSurname.toLowerCase() + "@hotmail.com";
        addmemberPage.name.sendKeys(expectedName);
        addmemberPage.surName.sendKeys(expectedSurname);
        addmemberPage.email.sendKeys(expectedEmail);
        addmemberPage.permission.click();
        addmemberPage.save.click();
    }


    String actualName;
    String actualSurname;
    String actualEmail;
    @Then("Verify that new member is seen under recordeds tab")
    public void verifyThatNewMemberIsSeenUnderRecordedsTab() {
        actualName = addmemberPage.registeredName.getText();
        actualSurname = addmemberPage.registeredSurName.getText();
        actualEmail = addmemberPage.registeredEmail.getText();
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedSurname,actualSurname);
        Assert.assertEquals(expectedEmail,actualEmail);
    }
}
