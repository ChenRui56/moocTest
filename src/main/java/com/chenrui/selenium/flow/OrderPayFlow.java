package com.chenrui.selenium.flow;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.operation.OrderPayOperation;

public class OrderPayFlow {
    private DriverBase driver;
    private OrderPayOperation orderPayOperation;

    public OrderPayFlow(DriverBase driver) {
        this.driver = driver;
        orderPayOperation = new OrderPayOperation(driver);
    }
    public void submit() {
        orderPayOperation.clickSubmitBtn();
    }

    public String getOutput() {
        return orderPayOperation.getCourseText();
    }
}
