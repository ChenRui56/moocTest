package com.chenrui.selenium.selenium.operation;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.page.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    /**
     * 获取用户名称
     * @return
     */
    public String getUserName() {
       return page.getUserName()==null ? "" : page.getUserName().getText();
    }

    /**
     * 将鼠标悬停在头像处
     */
    public void move2Header() {
        WebDriverWait wait = new WebDriverWait(driver.driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(page.getLocater("home.header.icon")));
        Actions actions = new Actions(driver.driver);
        actions.moveToElement(page.getHeaderIcon()).perform();

    }
}
