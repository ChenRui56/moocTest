package com.chenrui.selenium.testcase;

import com.chenrui.selenium.base.BaseCase;
import com.chenrui.selenium.flow.DetailFlow;
import com.chenrui.selenium.flow.OrderFlow;
import com.chenrui.selenium.flow.OrderPayFlow;
import com.chenrui.selenium.utils.PropertiesUtils;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BuyCourseCase extends BaseCase {

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        // 读取cookie
        driver.get("https://coding.imooc.com/class/437.html");
        String apsid = PropertiesUtils.getConfig("cookie.apsid");
        Cookie cookie = new Cookie("apsid", apsid,"imooc.com","/",null);
        driver.addCookie(cookie);
        driver.get("https://coding.imooc.com/class/437.html");
    }
    @Test
    public void testBuyCourse() {
        // 课程详情流程
        DetailFlow detailFlow = new DetailFlow(driver);
        String courseName = detailFlow.getOutPut();
        detailFlow.buyNow();
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
        Assert.assertEquals(courseName, orderPayFlow.getOutput());
        orderPayFlow.submit();
    }



}
