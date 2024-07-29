package com.solidgate.ui.utils;

public class StringUtils {

    public static int removeDotsAndParseToInt(String value) {
        return Integer.parseInt(value.replaceAll("[.]", ""));
    }
}