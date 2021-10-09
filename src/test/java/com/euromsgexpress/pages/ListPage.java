package com.euromsgexpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage {

    @FindBy(css = ".btn.btn-labeled.btn-purple")
    public WebElement createNewList;

    @FindBy(css = ".form-control.ng-pristine.ng-invalid.ng-touched")
    public WebElement nameTheList;

    @FindBy(css = "btn btn-labeled btn-success ng-star-inserted")
    public WebElement saveBar;

    @FindBy(xpath = "(//button[@class='btn btn-labeled btn-purple dropdown-toggle'])[1]")
    public WebElement addMember;

    @FindBy(xpath = "//a[.='Form ile Ekle']")
    public WebElement addMemberWithForm;

}
