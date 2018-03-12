package com.miniMVC.framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by yjq14 on 2018/3/12.
 */
@Target(ElementType.TYPE)
public @interface Aspect {
    Class<? extends Annotation> value();
}
