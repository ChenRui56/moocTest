package com.chenrui.selenium.page;

import com.chenrui.selenium.base.BasePage;
import com.chenrui.selenium.base.DriverBase;
import org.openqa.selenium.WebElement;

/**
 * 登录页面的pageObject
 */
public class LoginPage extends BasePage {
    public LoginPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取用户名输入框（手机号or邮箱）
     * @return
     */
   public WebElement getUserInput()  {
       return findElement("login.username");
   }

    /**
     * 获取密码输入框
     * @return
     */
   public WebElement getPasswordInput() {
       return findElement("login.password");
   }

    /**
     * 获取登录按钮
     * @return
     */
    public WebElement getLoginButton() {
        return findElement("login.button");
    }
}
