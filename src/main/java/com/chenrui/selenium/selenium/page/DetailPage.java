package com.chenrui.selenium.selenium.page;

import com.chenrui.selenium.base.BasePage;
import com.chenrui.selenium.base.DriverBase;
import org.openqa.selenium.WebElement;

/**
 * 实战详情页面对象
 */
public class DetailPage extends BasePage {
    public DetailPage(DriverBase driver) {
        super(driver);
    }

    /**
     * 获取立即购买按钮
     * @return
     */
    public WebElement getBuyButton() {
        return findElement("shizhan.buy.button");
    }

    /**
     * 获取课程标题
     * @return
     */
    public WebElement getCourseTitle() {
        return findElement("shizhan.course");
    }
}
