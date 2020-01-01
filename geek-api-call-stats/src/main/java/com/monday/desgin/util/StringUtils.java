package com.monday.desgin.util;

public class StringUtils {

    public static boolean isBlank(Object obj) {
        if (obj == null || "".equals(obj)) {
            return true;
        }
        return false;
    }

}
