package com.miniMVC.chapter2.test;

import com.miniMVC.framework.helper.DatabaseHelper;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by yjq14 on 2018/3/1.
 */
public class BaseTest {
    private String sqlFile;

    public BaseTest(String sqlFile) {
        this.sqlFile = sqlFile;
    }

    @Before
    public void initSql() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(sqlFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String sql;
        try {
            while ((sql=reader.readLine()) != null) {
                DatabaseHelper.executeUpdate(sql);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() {}
}
