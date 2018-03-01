package com.miniMVC.framework.helper;

import com.miniMVC.framework.ClassUtil;
import com.miniMVC.framework.ConfigHelper;

import java.util.Set;

/**
 * Created by yjq14 on 2018/3/2.
 */
public final class ClassHelper {
    private static Set<Class<?>> classSet;

    static {
        String basePackage = ConfigHelper.getBasePackage();
        classSet = ClassUtil.getClassSet(basePackage);
    }

    public static Set<Class<?>> getClassSet() {
        return classSet;
    }

    
}
