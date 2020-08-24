package com.chenrui.selenium.testcase;

import com.chenrui.selenium.base.BaseCase;
import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.constant.Constant;
import com.chenrui.selenium.flow.HomeFlow;
import com.chenrui.selenium.flow.LoginFlow;
import com.chenrui.selenium.utils.PropertiesUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginCase extends BaseCase {

    
    @BeforeSuite
    public void beforeSuilt() {
        logger.debug("------------------开始执行suit----------");
    }

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        driver.get("https://www.imooc.com/user/newlogin");
    }

    @Parameters({"userName","password","expected"})
    @Test
    public void testLogin(@Optional("135315261733") String userName,@Optional("11111") String password,@Optional("") String expected) {
        LoginFlow flow = new LoginFlow(driver);
        flow.login(userName,password);
        // 验证是否登录成功
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HomeFlow homeFlow = new HomeFlow(driver);
        String realName = homeFlow.getUserName();
        Assert.assertEquals(expected,realName);
    }

    @AfterMethod
    public void tearDown() {
        // 将登陆后的cookie保存到配置文件中去
        Cookie cookie = driver.manage().getCookieNamed("apsid");
        PropertiesUtils.updateConfig("cookie.apsid", cookie.getValue(), "cookie");
        logger.info("-----------------cookie更新----------------------");
    }

    @AfterSuite
    public void afterSuit() {
        logger.info("------------------结束执行suit----------");
    }
}
