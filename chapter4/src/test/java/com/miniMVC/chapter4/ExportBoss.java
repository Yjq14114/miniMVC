package com.miniMVC.chapter4;

import com.google.common.collect.Lists;
import com.miniMVC.framework.helper.DatabaseHelper;
import com.miniMvc.chapter4.entity.BossCouponEntity;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjq14 on 2018/7/27.
 */
public class ExportBoss {
    public List<BossCouponEntity> getBossCoupon() {
        String sql = "SELECT * FROM \"ERKUAI\".\"BOSS_COUPON\" where TELEPHONE = '18214028514'";
        return DatabaseHelper.queryEntityList(BossCouponEntity.class, sql);
    }
    @Test
    public void testExport() {
        List<BossCouponEntity> bossCoupon = getBossCoupon();
        System.out.println(bossCoupon);
    }
    @Test
    public void insertTradeNo() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("file/trade_no.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String tradeNo;
        try {
            while ((tradeNo=reader.readLine()) != null) {
                insertSql(tradeNo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void  insertSql(String tradeNo) {
        String sql = "INSERT INTO \"ERKUAI\".\"TRADE_NO_TEMP\" (\"ID\", \"TRADE_NO\") VALUES (TRADE_NO_TEMP_seq.nextval, '"+tradeNo+"')";
        DatabaseHelper.executeUpdate(sql);
    }
    private void insertNumber(String mobile, String number) {
        String sql = "INSERT INTO \"ERKUAI\".\"SERIAL_NUMBER_TEMP\" (\"ID\", \"MOBILE\", \"SERIAL_NUMBER\") VALUES (SERIAL_NUMBER_temp_seq.nextval, '"+mobile+"', '"+number+"')";
        DatabaseHelper.executeUpdate(sql);
    }
    @Test
    public void insertNumber() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("file/number.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String number;
        try {
            while ((number=reader.readLine()) != null) {
                String[] split = number.split(",");
                insertNumber(split[0], split[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
