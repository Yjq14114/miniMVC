package com.test.groovy

import org.testng.Assert
import org.testng.annotations.Test

import java.lang.reflect.Method

import static com.miniMVC.framework.ClassUtil.getClassSet
import static com.miniMVC.framework.ClassUtil.loadClass

/**
 * Created by yjq14 on 2018/6/14.
 */
class ClassUtilTest {
    @Test
    void testLoadClass(){
        def clazz1 = loadClass("com.miniMVC.framework.ClassUtil")
        def method = clazz1.getMethod("getClassLoader")
        Assert.assertEquals("getClassLoader", method.getName())
    }
    @Test
    void testGetClassSet() {
        def packageName = "com.miniMVC.framework"
        def set = getClassSet(packageName)
        Assert.assertNotNull(set)
    }
    @Test
    void testGetJarSet() {
        def jarName = 'org.yaml.snakeyaml'
        def set = getClassSet(jarName)
        Assert.assertNotNull(set)
    }
}
