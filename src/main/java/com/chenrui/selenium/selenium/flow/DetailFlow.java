package com.chenrui.selenium.selenium.flow;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.operation.DetailPageOperation;

/**
 * 课程详情
 */
public class DetailFlow {
    private DriverBase driver;
    private DetailPageOperation operation;

    public DetailFlow(DriverBase driver) {
        this.driver = driver;
        operation = new DetailPageOperation(driver);
    }

    /**
     * 立即购买
     */
    public void buyNow() {
        operation.clickByButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 参数传递
     * @return
     */
    public String getOutPut() {
        return operation.getCourseTitle();
    }

}
