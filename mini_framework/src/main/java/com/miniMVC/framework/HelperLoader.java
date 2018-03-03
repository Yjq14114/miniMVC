package com.miniMVC.framework;

import com.miniMVC.framework.annotation.Controller;
import com.miniMVC.framework.helper.BeanHelper;
import com.miniMVC.framework.helper.ClassHelper;
import com.miniMVC.framework.helper.ControllerHelper;
import com.miniMVC.framework.helper.IocHelper;

/**
 * Created by yjq14 on 2018/3/4.
 */
public class HelperLoader {
    public static void init() {
        Class<?> [] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls :
                classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
