package com.miniMVC.commons;

import java.util.List;

/**
 * @Author: YangJiaQi
 * @Date: 2019/7/23 20:19
 */
public class ListUtils {
    /**
     * sublist分页
     * @param limit
     * @param list
     */
    public static void pageList(int limit, List<String> list) {
        int size = list.size();
        int remainder = size % limit;
        int quotient = size / limit;
        if (remainder != 0) {
            quotient++;
        }
        for (int i = 0; i < quotient; i++) {
            int fromIndex = i * limit;
            int toIndex = (i == quotient -1 && remainder !=0)?(i * limit) + remainder:(i * limit) + limit;
            List<String> subList = list.subList(fromIndex, toIndex);
            System.out.println(subList);
        }
    }
}
