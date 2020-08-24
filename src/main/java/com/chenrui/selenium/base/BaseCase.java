package com.chenrui.selenium.base;

import com.chenrui.selenium.constant.Constant;
import com.chenrui.selenium.testcase.BuyCourseCase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseCase {
    protected Logger logger = Logger.getLogger(BuyCourseCase.class);
    protected DriverBase driver;

    public WebDriver getDriver() {
        return driver.driver;
    }
    @BeforeClass
    public void beforeClass() {
        logger.info("----------------开始执行"+ getClass().getName() + "-----------------");
        driver = new DriverBase(Constant.DRIVER_FIREFOX);
    }

    @AfterClass
    public void afterClass() {
        logger.info("-----------------------执行结束"+ getClass().getName() + "-------------------");
        driver.stop();
    }
}
