package com.chenrui.selenium.selenium.testcase;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.constant.Constant;
import com.chenrui.selenium.flow.*;
import com.chenrui.selenium.parameter.LoginParameter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MoocTestCase {
    DriverBase driver;

    @BeforeClass
    public void setUp() {
        driver = new DriverBase(Constant.DRIVER_FIREFOX);
        driver.get("https://www.imooc.com/");

    }
    @Test
    public void openLoginPage() {
        HomeFlow homeFlow = new HomeFlow(driver);
        homeFlow.openLoginPage();
    }
    // todo 1.数据和业务分离 2.断言结果
    @Test(dependsOnMethods = "openLoginPage")
    public void login() {
        LoginParameter parameter = new LoginParameter();
        parameter.setPassword("XXX");
        parameter.setUser("XXXX");
//        LoginFlow loginFlow = new LoginFlow(driver,parameter);
//        loginFlow.getStartPage(new HomePageOperation(driver));
//        loginFlow.login();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test(dependsOnMethods = {"openLoginPage","login"})
    public void buyCourse() {
        driver.get("https://coding.imooc.com/class/446.html");
        DetailFlow detailFlow = new DetailFlow(driver);
        String courseTitle = detailFlow.getOutPut();
        detailFlow.buyNow();
        OrderFlow orderFlow = new OrderFlow(driver);
        Assert.assertEquals(courseTitle, orderFlow.getOutput());
        orderFlow.submit();
        OrderPayFlow payFlow = new OrderPayFlow(driver);
        String output = payFlow.getOutput();
        Assert.assertEquals(courseTitle, output);
        orderFlow.submit();
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
