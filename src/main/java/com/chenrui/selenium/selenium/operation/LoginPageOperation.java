package com.chenrui.selenium.selenium.operation;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.page.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 登录页面操作类
 */
public class LoginPageOperation {
    public DriverBase driver;
    public LoginPage loginPage;

    public LoginPageOperation(DriverBase driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    /**
     * 输入用户账号
     */
    public void sendKeysUserInput(String userInfo) {
        WebDriverWait wait = new WebDriverWait(driver.driver,5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPage.getLocater("login.username")));
         loginPage.getUserInput().sendKeys(userInfo);
    }

    /**
     * 输入密码
     * @param password 密码
     *
     */
    public void sendKeysPasswordInput(String password) {
        loginPage.getPasswordInput().sendKeys(password);
    }

    /**
     * 点击登录按钮
     */
    public void clickedLoginBtn() {
        loginPage.getLoginButton().click();
    }

    /**
     * 检查是否是登录界面
     * @return
     */
    public boolean assertLoginPage() {
        return loginPage.getUserInput().isDisplayed();
    }


}
