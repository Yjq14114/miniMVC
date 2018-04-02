package com.miniMVC.framework.bean;

import com.miniMVC.commons.CastUtil;
import com.miniMVC.commons.CodecUtil;
import com.miniMVC.commons.CollectionUtil;
import com.miniMVC.commons.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yjq14 on 2018/3/4.
 */
public class Param {
    private Map<String, Object> paramMap;
    private List<FormParam> formParamList;
    private List<FileParam> fileParamList;

    public Param(List<FormParam> formParamList, List<FileParam> fileParamList) {
        this.formParamList = formParamList;
        this.fileParamList = fileParamList;
    }

    public Param(List<FormParam> formParamList) {
        this.formParamList = formParamList;
    }

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
        return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
    }

    /**
     * 获取参数
     * @return
     */
    public Map<String, Object> getFieldMap() {
        Map<String, Object> fieldMap = new HashMap<>();
        if(CollectionUtil.isNotEmpty(formParamList)) {
            for (FormParam formParam:formParamList) {
                String fieldName = formParam.getFieldName();
                Object fieldValue = formParam.getFieldValue();
                if (fieldMap.containsKey(fieldName)) {
                    fieldValue = fieldMap.get(fieldName) + StringUtil.SEPARATOR + fieldValue;
                }
                fieldMap.put(fieldName, fieldValue);
            }
        }
        return fieldMap;
    }

    /**
     * 获取文件
     * @return
     */
    public Map<String, List<FileParam>> getFileMap() {
        Map<String, List<FileParam>> fileMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(fileParamList)) {
            for (FileParam param: fileParamList) {
                String fieldName = param.getFieldName();
                List<FileParam> list;
                if (fileMap.containsKey(fieldName)){
                   list = fileMap.get(fieldName);
                } else {
                    list = new ArrayList<>();
                }
                list.add(param);
                fileMap.put(fieldName, list);
            }
        }
        return fileMap;
    }
    public List<FileParam> getFileList(String fieldName) {
        return getFileMap().get(fieldName);
    }
    public FileParam getFile(String filedName) {
        List<FileParam> list = getFileMap().get(filedName);
        if (CollectionUtil.isNotEmpty(list) && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
    public boolean isListEmpty() {
        return CollectionUtil.isEmpty(formParamList) && CollectionUtil.isEmpty(fileParamList);
    }
    public String getString(String name) {
        return CastUtil.castString(getFieldMap().get(name));
    }
    public double getDouble(String name) {
        return CastUtil.castDouble(getFieldMap().get(name));
    }
    public long getFieldLong(String name) {
        return CastUtil.castLong(getFieldMap().get(name));
    }
    public int getInt(String name) {
        return CastUtil.castInt(getFieldMap().get(name));
    }
    public boolean getBoolean(String name) {
        return CastUtil.castBoolean(getFieldMap().get(name));
    }


}
