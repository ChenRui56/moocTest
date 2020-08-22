package com.chenrui.selenium.selenium.page;

import com.chenrui.selenium.base.BasePage;
import com.chenrui.selenium.base.DriverBase;
import org.openqa.selenium.WebElement;

public class OrderPayPage extends BasePage {
    public OrderPayPage(DriverBase driver) {
        super(driver);
    }

    public WebElement getCourseTitle() {
        return findElement("orderpay.course");
    }
    public WebElement getOrderNum() {
        return findElement("orderpay.num=");
    }
    public WebElement getSubmitBtn() {
        return findElement("orderpay.submit");
    }
}
