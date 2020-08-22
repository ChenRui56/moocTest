package com.chenrui.selenium.selenium.testcase;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.constant.Constant;
import com.chenrui.selenium.flow.HomeFlow;
import com.chenrui.selenium.flow.LoginFlow;
import com.chenrui.selenium.utils.PropertiesUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginCase {
    DriverBase driver;
    private Logger logger = Logger.getLogger(LoginCase.class);
    
    @BeforeSuite
    public void beforeSuilt() {
        logger.info("------------------开始执行suit----------");
    }

    @BeforeClass
    public void beforeClass() {
        logger.info("------------------开始执行LoginCase.class----------");
        driver = new DriverBase(Constant.DRIVER_FIREFOX);
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
        // 将登陆后的cookie保存到配置文件中去
        Cookie cookie = driver.manage().getCookieNamed("apsid");
        PropertiesUtils.updateConfig("cookie.apsid", cookie.getValue(), "cookie");
        logger.info("-----------------cookie更新----------------------");
    }

    @AfterClass
    public void afterClass() {
        logger.info("------------------结束执行LoginCase.class----------");
    }
    @AfterSuite
    public void afterSuit() {
        logger.info("------------------结束执行suit----------");
        driver.stop();
    }
}
