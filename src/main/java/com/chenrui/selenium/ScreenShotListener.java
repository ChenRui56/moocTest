package com.chenrui.selenium;

import com.chenrui.selenium.base.BaseCase;
import com.chenrui.selenium.utils.TakeScreenShotUtils;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class ScreenShotListener extends TestListenerAdapter {
    private Logger logger = Logger.getLogger(ScreenShotListener.class);
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        BaseCase baseCase = (BaseCase) tr.getInstance();
        TakeScreenShotUtils.takeScreenShot(baseCase.getDriver());
    }
}
