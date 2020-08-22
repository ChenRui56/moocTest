package com.chenrui.selenium.selenium.page;

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

    /**
     * 获取右上角的头像icon
     * @return
     */
    public WebElement getHeaderIcon() {
        return findElement("home.header.icon");
    }

    /**
     * 获取登录用户名称
     * @return
     */
    public WebElement getUserName() {
        return findElement("home.username");
    }

}
