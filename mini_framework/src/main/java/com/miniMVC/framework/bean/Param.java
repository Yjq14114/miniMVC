package com.miniMVC.framework.bean;

import com.miniMVC.commons.CastUtil;
import com.miniMVC.commons.CollectionUtil;

import java.util.Map;

/**
 * Created by yjq14 on 2018/3/4.
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }
    public Map<String, Object> getMap(){
        return paramMap;
    }
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }
}
