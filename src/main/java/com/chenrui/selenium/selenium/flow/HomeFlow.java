package com.chenrui.selenium.selenium.flow;

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

    /**
     * 获取登录用户名称
     * @return
     */
    public String  getUserName() {
        operation.move2Header();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return operation.getUserName();
    }
}
