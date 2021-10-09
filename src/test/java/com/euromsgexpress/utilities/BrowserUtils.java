package com.euromsgexpress.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static WebElement waitForClickability(WebElement element, int time){
        WebDriverWait webDriverWait = new WebDriverWait(Driver.get(),time);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebElement element,int time){
        WebDriverWait webDriverWait = new WebDriverWait(Driver.get(),time);
        return webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
