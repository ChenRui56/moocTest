package com.chenrui.selenium.selenium.page;

import com.chenrui.selenium.base.BasePage;
import com.chenrui.selenium.base.DriverBase;
import org.openqa.selenium.WebElement;

/**
 * 确认订单页面
 */
public class OrderPage extends BasePage {
    public OrderPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取课程标题
     * @return
     */
    public WebElement getCourseTitle() {
        return findElement("order.course");
    }

    public WebElement getSubmitBtn() {
        return findElement("order.submit");
    }
}
