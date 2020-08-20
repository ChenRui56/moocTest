package com.chenrui.selenium.constant;

public class Constant {
    /************************* 驱动方式 **************************/
//    https://github.com/mozilla/geckodriver/releases
    public final static String DRIVER_FIREFOX = "Firefox";

//    https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver
    public final static String DRIVER_EDGE = "Edge";

//    https://npm.taobao.org/mirrors/chromedriver
    public final static String DRIVER_CHROME = "Chrome";

//    http://selenium-release.storage.googleapis.com/index.html
    public final static String DRIVER_IE = "IE";

//    https://github.com/operasoftware/operachromiumdriver/releases
    public final static String DRIVER_OPERA = "Opera";

    public final static String DRIVER_SAFARI = "Safari";

    /************************** 定位方式 *****************************/
    public final static String LOCATION_ID = "id";
    public final static String LOCATION_NAME = "name";
    public final static String LOCATION_CLASS_NAME = "className";
    public final static String LOCATION_XPATH = "xpath";
    public final static String LOCATION_LINK_TEXT = "linkText";
    public final static String LOCATION_PARTIAL_LINK_TEXT = "partialLinkText";
    public final static String LOCATION_TAG_NAME = "tagName";
    public final static String LOCATION_CSS_SELECTOR = "cssSelector";

}
