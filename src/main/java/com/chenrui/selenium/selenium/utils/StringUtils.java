package com.chenrui.selenium.selenium.utils;

public class StringUtils {
    public static boolean isEmpty(String str) {
        return null == str || str.trim().equals("");
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
