package com.euromsgexpress.stepDefinitions;

import com.euromsgexpress.pages.HomePage;
import com.euromsgexpress.pages.ListPage;
import com.euromsgexpress.utilities.BrowserUtils;
import com.euromsgexpress.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class Membership_defs {
    //
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.get();
    //
    HomePage homePage = new HomePage();
    ListPage listPage = new ListPage();

    @When("Click Üyelerini Ekle bar")
    public void clickÜyeleriniEkleBar() {
        homePage.addToYourMembers.click();
    }

    @And("Click Yeni Liste Oluştur bar")
    public void clickYeniListeOluşturBar() {
        BrowserUtils.waitForClickability(listPage.createNewList,7);
        listPage.createNewList.click();
    }


    @And("Name the list as {string} and save it")
    public void nameTheListAs(String arg0) {
        //BrowserUtils.waitForClickability(listPage.nameTheList,7);
        javascriptExecutor.executeScript("arguments[0].setAttribute('value', 'textBoxValue')", listPage.nameTheList);
        listPage.saveBar.click();
    }

    @And("Add new member using add with form")
    public void addNewMemberUsingAddWithForm() {
        listPage.addMember.click();
        listPage.addMemberWithForm.click();
    }
}
