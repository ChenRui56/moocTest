package com.chenrui.selenium.selenium.flow;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.operation.LoginPageOperation;
import org.apache.log4j.Logger;

public class LoginFlow  {
    private final LoginPageOperation operation;
//    private final LoginParameter parameter;

    Logger log = Logger.getLogger(getClass());

    public LoginFlow(DriverBase driver) {
        operation = new LoginPageOperation(driver);
//        this.parameter = parameter;
    }

    public void login(String userName, String password) {
        if (operation.assertLoginPage()) {
            operation.sendKeysUserInput(userName);
            operation.sendKeysPasswordInput(password);
            operation.clickedLoginBtn();

        } else {
            log.error("登录页面不存在或者状态不正确");
        }
    }



}
