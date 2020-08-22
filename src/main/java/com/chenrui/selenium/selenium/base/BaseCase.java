package com.chenrui.selenium.selenium.base;

import com.chenrui.selenium.base.DriverBase;

public class BaseCase {
    protected DriverBase driver;

    public BaseCase(String browser) {
            this.driver = new DriverBase(browser);
    }

}
