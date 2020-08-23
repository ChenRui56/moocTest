package com.chenrui.selenium.testcase;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.constant.Constant;
import com.chenrui.selenium.flow.DetailFlow;
import com.chenrui.selenium.flow.OrderFlow;
import com.chenrui.selenium.flow.OrderPayFlow;
import com.chenrui.selenium.utils.PropertiesUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BuyCourseCase {
    private Logger logger = Logger.getLogger(BuyCourseCase.class);
    private DriverBase driver;
    @BeforeClass
    public void beforeClass() {
        logger.info("----------------开始执行BuyCourseCase-----------------");
        driver = new DriverBase(Constant.DRIVER_FIREFOX);
        // 读取cookie
        String apsid = PropertiesUtils.getConfig("cookie.apsid");
        Cookie cookie = new Cookie("apsid", apsid);
        driver.addCookie(cookie);
        driver.get("https://coding.imooc.com/class/437.html");
    }
    @Test
    public void testBuyCourse() {
        // 课程详情流程
        DetailFlow detailFlow = new DetailFlow(driver);
        detailFlow.buyNow();
        String courseName = detailFlow.getOutPut();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 确认订单
        OrderFlow orderFlow = new OrderFlow(driver);
        orderFlow.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //支付中心
        OrderPayFlow orderPayFlow = new OrderPayFlow(driver);
        orderPayFlow.submit();
        Assert.assertEquals(courseName, orderPayFlow.getOutput());
    }


    @AfterClass
    public void afterClass() {
        logger.info("-----------------------执行结束BuyCourseCase-------------------");
        driver.stop();
    }
}
