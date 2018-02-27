package com.miniMVC.commons;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hy06 on 2018/2/27.
 */
public final class StringUtil {
    public static boolean isEmpty(String str) {
        if (str != null) {
            str.trim();
        }
        return StringUtils.isEmpty(str);
    }
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
