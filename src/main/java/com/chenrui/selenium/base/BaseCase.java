package com.chenrui.selenium.base;

public class BaseCase {
    protected DriverBase driver;

    public BaseCase(String browser) {
            this.driver = new DriverBase(browser);
    }

}
