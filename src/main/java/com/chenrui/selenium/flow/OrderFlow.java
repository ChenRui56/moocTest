package com.chenrui.selenium.flow;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.operation.OrderOperation;

public class OrderFlow {
    private OrderOperation operation;
    private DriverBase driver;

    public OrderFlow(DriverBase driver) {
        this.driver = driver;
        operation = new OrderOperation(driver);
    }

    public void submit() {
        operation.clickSubmitBtn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getOutput() {
        return operation.getCourseTitle();
    }
}
