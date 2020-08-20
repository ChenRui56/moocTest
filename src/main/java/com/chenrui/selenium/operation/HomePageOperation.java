package com.chenrui.selenium.operation;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.page.HomePage;

public class HomePageOperation {
    private HomePage page;
    private DriverBase driver;

    public HomePageOperation(DriverBase driver) {
        this.driver = driver;
        page = new HomePage(driver);
    }

    /**
     * 点击首页的登录按钮
     */
    public void clickLoginButton() {
        page.getLoginButton().click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
