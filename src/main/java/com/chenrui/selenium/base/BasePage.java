package com.chenrui.selenium.base;

import com.chenrui.selenium.constant.Constant;
import com.chenrui.selenium.utils.PropertiesUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.bind.ValidationEvent;

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
     * @param key 配置文件中对应的key
     * @return
     */
    public WebElement findElement(String key) {
        return driver.driver.findElement(getLocater(key));
    }

    /**
     * 从配置文件中读取定位方式
     * @param key
     * @return
     */
    private By getLocater(String key) {
        String values = PropertiesUtils.getConfig(key);
        String[] str = values.split(">");

        // 定位的方式 eg：id、className...
        String mode = str[0];
        String value = str[1];

        By by;

        switch (mode) {
            case Constant.LOCATION_CLASS_NAME:
                by = By.className(value);
                break;
            case Constant.LOCATION_CSS_SELECTOR:
                by = By.cssSelector(value);
                break;
            case Constant.LOCATION_ID:
                by = By.id(value);
                break;
            case Constant.LOCATION_LINK_TEXT:
                by = By.linkText(value);
                break;
            case Constant.LOCATION_NAME:
                by = By.name(value);
                break;
            case Constant.LOCATION_PARTIAL_LINK_TEXT:
                by = By.partialLinkText(value);
                break;
            case Constant.LOCATION_TAG_NAME:
                by = By.tagName(value);
                break;
            default:
                by = By.xpath(value);
                break;
        }
        return by;
    }
}
