package com.miniMVC.framework.helper;

import com.miniMVC.framework.bean.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yjq14 on 2018/3/4.
 */
public class ControllerHelper {
    private static final Map<Request, Object> ACTION_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();

    }
}
