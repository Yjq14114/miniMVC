package com.miniMVC.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by yjq14 on 2018/3/12.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    Class<? extends Annotation> value();
}
