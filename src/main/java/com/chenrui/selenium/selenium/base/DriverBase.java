package com.chenrui.selenium.selenium.base;

import com.chenrui.selenium.constant.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverBase {
    public  WebDriver driver;

    public DriverBase(String browser) {
        driver = selectWebDriver(browser);
    }

    public void stop() {
        driver.close();
    }

    public void get(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();

    }

    public WebDriver.Options manage() {
        return driver.manage();
    }


    /**
     *  创建对应的浏览器驱动
     * @param browser 浏览器类型
     * @return
     */
    private WebDriver selectWebDriver(String browser) {
        switch (browser) {
            case Constant.DRIVER_CHROME:
                driver = new ChromeDriver();
                break;
            case Constant.DRIVER_EDGE:
                driver = new EdgeDriver();
                break;
            case Constant.DRIVER_FIREFOX:
                System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");
                driver = new FirefoxDriver();
                break;
            case Constant.DRIVER_IE:
                driver = new InternetExplorerDriver();
                break;
            case Constant.DRIVER_OPERA:
                driver = new OperaDriver();
                break;
            default:
                driver = new SafariDriver();
                break;
        }
        Actions actions = new Actions(driver);
        actions.click().perform();
        return driver;
    }
}
