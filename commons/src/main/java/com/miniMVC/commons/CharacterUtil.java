package com.miniMVC.commons;

import java.io.UnsupportedEncodingException;

/**
 * Created by yjq14 on 2018/4/2.
 */
public class CharacterUtil {
    /**
     * 判断字符为中文
     * @param c
     * @return
     */
    public static boolean isChineseByScript(char c) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if (sc == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }
    public static boolean isChineseByStr(String str) {
        char[] chars = str.toCharArray();
        for (char c :
                chars) {
           if (isChineseByScript(c)) return true;
        }
        return false;
    }

    public static String toChinese(String str) throws UnsupportedEncodingException {
        return new String(str.getBytes("iso8859-1"), "utf-8");
    }

}
