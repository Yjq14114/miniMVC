package com.miniMVC.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by yjq14 on 2018/3/4.
 */
public final class CodecUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    public static String encodeUrl(String source) {
        try {
            source = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("url encode error", e);
            new RuntimeException(e);
        }
        return source;
    }
    public static String decodeUrl(String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("url decode error", e);
            new RuntimeException(e);
        }
        return str;
    }
}
