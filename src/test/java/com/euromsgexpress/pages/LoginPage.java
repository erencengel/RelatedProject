package com.euromsgexpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//a[@class='et_pb_button et_pb_button_0_tb_header hvr-buzz-out et_pb_bg_layout_light']")
    public WebElement entryButton;

    @FindBy(css = "input[name='email']")
    public WebElement emailBox;

    @FindBy(css = "input[name='password']")
    public WebElement passwordBox;

    @FindBy(css = "#recaptcha-anchor")
    public WebElement captcha;

    @FindBy(xpath = "//button[.=' Login ']")
    public WebElement loginButton;

    @FindBy(xpath = "(//div[@class='input-warning'])[1]")
    public WebElement emailBoxWarning;

    @FindBy(xpath = "(//div[@class='input-warning'])[2]")
    public WebElement passwordBoxWarning;

    @FindBy(css = ".btn.btn-block.btn-secondary")
    public WebElement forgotPasswordButton;

    @FindBy(css = "#exampleInputEmail1")
    public WebElement emailBoxForNewPassword;

    @FindBy(css = ".btn.btn-block.mt-3.btn-primary")
    public WebElement sendButton;

    @FindBy(css = ".text-center.py-2")
    public WebElement resetMessageVerification;

}
