package com.chenrui.selenium.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShotUtils {

    public static void takeScreenShot(WebDriver driver) {
        String date = String.valueOf(System.currentTimeMillis());
        String path = System.getProperty("user.dir") + "\\fail-img\\"+date +".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
