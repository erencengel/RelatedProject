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

    String name;
    String surName;
    String email;
    @And("Add new member using add with form")
    public void addNewMemberUsingAddWithForm() {
        listPage.addMember.click();
        listPage.addMemberWithForm.click();
        name = faker.name().firstName();
        surName = faker.name().lastName();
        email = name.toLowerCase() + "." + surName.toLowerCase() + "@hotmail.com";
        addmemberPage.name.sendKeys(name);
        addmemberPage.surName.sendKeys(surName);
        addmemberPage.email.sendKeys(email);
        addmemberPage.permission.click();
        addmemberPage.save.click();
    }

    @Then("Verify that new member is seen under recordeds tab")
    public void verifyThatNewMemberIsSeenUnderRecordedsTab() {
    }
}
