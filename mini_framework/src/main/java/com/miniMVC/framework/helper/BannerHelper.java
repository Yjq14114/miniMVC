package com.miniMVC.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.out;

/**
 * Created by yjq14 on 2018/4/6.
 */
public final class BannerHelper {
    private static final Logger logger = LoggerFactory.getLogger(BeanHelper.class);
    static {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/banner.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String context = "";
        try {
            while ((context=reader.readLine()) != null) {
                Thread.sleep(100);
                out.println(context);
            }
        } catch (IOException e) {
            logger.error("reader failure", e);
        } catch (InterruptedException e) {
            logger.error("sleep failure", e);
        }
    }
}
