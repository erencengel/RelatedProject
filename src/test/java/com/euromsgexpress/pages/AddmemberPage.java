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

}
