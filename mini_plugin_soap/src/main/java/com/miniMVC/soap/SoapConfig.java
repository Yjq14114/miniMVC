package com.miniMVC.soap;

import com.miniMVC.framework.ConfigHelper;

/**
 * Created by yjq14 on 2018/4/6.
 */
public class SoapConfig {
    public static boolean isLog() {
        return ConfigHelper.getBoolean(SoapConstant.LOG);
    }
}
