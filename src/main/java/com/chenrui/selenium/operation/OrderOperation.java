package com.chenrui.selenium.operation;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.page.OrderPage;

public class OrderOperation {
    private DriverBase driver;
    private OrderPage page;

    public OrderOperation(DriverBase driver) {
        this.driver = driver;
        page = new OrderPage(driver);
    }

    public String getCourseTitle() {
        return page.getCourseTitle().getText();
     }

    public void clickSubmitBtn() {
        page.getSubmitBtn().click();
    }
}
