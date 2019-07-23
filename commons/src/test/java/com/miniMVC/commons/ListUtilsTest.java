package com.miniMVC.commons;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YangJiaQi
 * @Date: 2019/7/23 20:25
 */
public class ListUtilsTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        ListUtils.pageList(3, list);
    }
}
