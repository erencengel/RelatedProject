package com.euromsgexpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddmemberPage extends BasePage{

    @FindBy(css = "input[placeholder='Ad']")
    public WebElement name;

    @FindBy(css = "input[placeholder='Soyad']")
    public WebElement surName;

    @FindBy(css = "input[placeholder='E-Posta']")
    public WebElement email;

    @FindBy(css = ".fa.fa-check")
    public WebElement permission;

    @FindBy(css = ".btn.btn-labeled.btn-success")
    public WebElement save;

    @FindBy(css = ".table-responsive.ng-star-inserted table tbody tr td:nth-of-type(2)")
    public WebElement registeredName;

    @FindBy(css = ".table-responsive.ng-star-inserted table tbody tr td:nth-of-type(3)")
    public WebElement registeredSurName;

    @FindBy(css = ".table-responsive.ng-star-inserted table tbody tr td:nth-of-type(1)")
    public WebElement registeredEmail;

}
