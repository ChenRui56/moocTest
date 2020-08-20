package com.chenrui.selenium.flow;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.operation.HomePageOperation;

public class HomeFlow {
    private DriverBase driver;
    private HomePageOperation operation;

    public HomeFlow(DriverBase driver) {
        this.driver = driver;
        operation = new HomePageOperation(driver);
    }

    public void openLoginPage() {
        operation.clickLoginButton();
    }
}
