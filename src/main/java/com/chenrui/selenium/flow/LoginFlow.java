package com.chenrui.selenium.flow;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.operation.LoginPageOperation;
import com.chenrui.selenium.parameter.LoginParameter;
import org.apache.log4j.Logger;

public class LoginFlow  {
    private final LoginPageOperation operation;
    private final LoginParameter parameter;

    Logger log = Logger.getLogger(getClass());

    public LoginFlow(DriverBase driver,LoginParameter parameter) {
        operation = new LoginPageOperation(driver);
        this.parameter = parameter;
    }

    public void login() {
        if (operation.assertLoginPage()) {
            operation.sendKeysUserInput(parameter.getUser());
            operation.sendKeysPasswordInput(parameter.getPassword());
            operation.clickedLoginBtn();

        } else {
            log.error("登录页面不存在或者状态不正确");
        }
    }

    /**
     * 打开登录页面
     * @param operation
     */
//    public void getStartPage(HomePageOperation operation) {
//        operation.clickLoginButton();
//    }



}
