package com.miniMVC.rest;

import com.miniMVC.commons.StringUtil;
import com.miniMVC.framework.ConfigHelper;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yjq14 on 2018/4/6.
 */
public class RestConfig {
    public static boolean isLog() {
        return ConfigHelper.getBoolean(RestConstant.LOG);
    }
    public static boolean isJsonP() {
        return ConfigHelper.getBoolean(RestConstant.JSONP);
    }
    public static String getJsonPFunction() {
        return ConfigHelper.getString(RestConstant.JSONP_FUNCTION);
    }
    public static boolean isCors() {
        return ConfigHelper.getBoolean(RestConstant.CORS);
    }
    public static List<String> getCorsOriginList() {
        String corsOrigin = ConfigHelper.getString(RestConstant.CORS_ORIGIN);
        return Arrays.asList(StringUtil.splitString(corsOrigin, ","));
    }
}
