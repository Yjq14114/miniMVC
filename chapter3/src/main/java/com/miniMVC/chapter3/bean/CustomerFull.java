package com.miniMVC.chapter3.bean;

import com.miniMVC.commons.JsonUtil;
import com.miniMVC.framework.ReflectionUtil;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by yjq14 on 2018/6/22.
 */
public class CustomerFull extends Customer{
    private Boolean flag;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Customer customer = new Customer();
        customer.setName("yangjiaqi");
        customer.setId(12343l);
        customer.setContact(null);
        HashedMap addProperties = new HashedMap() {
            {
                put("flag", true);
            }
        };
        Object target = ReflectionUtil.getTarget(customer, addProperties);
        String s = JsonUtil.toJson(target);
        System.out.println(s);
        Map map = ReflectionUtil.getBeanMap(customer, addProperties);
        String s1 = JsonUtil.toJson(map);
        System.out.println(s1);
    }
}
