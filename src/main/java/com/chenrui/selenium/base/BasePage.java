package com.chenrui.selenium.base;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 页面对象的基类
 */
public class BasePage {
    protected Logger log = Logger.getLogger(BasePage.class);
    protected DriverBase driver;

    public BasePage(DriverBase driver) {
        this.driver = driver;
    }

    /**
     * 封装定位
     * @param by
     * @return
     */
    public WebElement findElement(By by) {
        return driver.driver.findElement(by);
    }

}
