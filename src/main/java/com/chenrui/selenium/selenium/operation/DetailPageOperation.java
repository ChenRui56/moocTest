package com.chenrui.selenium.selenium.operation;

import com.chenrui.selenium.base.DriverBase;
import com.chenrui.selenium.page.DetailPage;

public class DetailPageOperation {
    private DriverBase driver;
    private DetailPage page;

    public DetailPageOperation(DriverBase driver) {
        this.driver = driver;
        page = new DetailPage(driver);
    }

    /**
     * 点击立即购买按钮
     */
    public void clickByButton() {
        page.getBuyButton().click();
    }

    /**
     * 获取课程标题
     * @return
     */
    public String getCourseTitle() {
        return page.getCourseTitle().getText();
    }
}
