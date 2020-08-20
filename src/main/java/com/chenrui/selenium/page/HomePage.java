package com.chenrui.selenium.page;

import com.chenrui.selenium.base.BasePage;
import com.chenrui.selenium.base.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(DriverBase driver) {
        super(driver);
    }

    public WebElement getLoginButton(){
        // fixme
        WebDriverWait driverWait = new WebDriverWait(driver.driver,10);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("js-signin-btn")));
        return findElement("home.signin.button");
    }
}
