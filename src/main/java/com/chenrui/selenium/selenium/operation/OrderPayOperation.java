package com.chenrui.selenium.selenium.operation;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.page.OrderPayPage;

public class OrderPayOperation {
    private DriverBase driver;
    private OrderPayPage page;

    public OrderPayOperation(DriverBase driver) {
        this.driver = driver;
        page = new OrderPayPage(driver);
    }


    public String getCourseText() {
        return page.getCourseTitle() == null ? "" : page.getCourseTitle().getText();
    }
    public void clickSubmitBtn() {
        page.getSubmitBtn().click();
    }
}
