package com.miniMVC.chapter4;

import com.miniMVC.framework.helper.DatabaseHelper;
import com.miniMvc.chapter4.entity.Boss_coupon_status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by yjq14 on 2018/4/9.
 */
public class TestBossData {
    public List<Boss_coupon_status> getBossCoupon() {
        String sql = "SELECT * FROM BOSS_COUPON_STATUS WHERE STATUS = 1 AND TRADE_NO NOT IN ( SELECT TRADE_NO FROM BOSS_COUPON_STATUS WHERE STATUS = 2 )";
        return DatabaseHelper.queryEntityList(Boss_coupon_status.class, sql);
    }
    public List<Map<String,Object>> getBoos(){
        String sql = "SELECT TRADE_NO FROM BOSS_COUPON_STATUS WHERE STATUS = 1 AND TRADE_NO NOT IN ( SELECT TRADE_NO FROM BOSS_COUPON_STATUS WHERE STATUS = 2 )";
        return DatabaseHelper.mapListHandler(sql);
    }
    @Test
    public void testBoss() {
        List<Boss_coupon_status> bossCoupon = getBossCoupon();
        for (Boss_coupon_status bs:bossCoupon) {
            System.out.println(bs.toString());
        }
    }
    @Test
    public void test(){
        List<Map<String, Object>> boos = getBoos();
        for (Map<String, Object> map :
                boos) {
            System.out.println(map.toString());
        }
    }
    public Boss_coupon_status getBossStatus(String tradeNo) {
        String sql = "SELECT * FROM BOSS_COUPON_STATUS WHERE trade_no = "+tradeNo+"";
        return DatabaseHelper.queryEntityList(Boss_coupon_status.class, sql).get(0);
    }

    public void exportSql() {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("file/trade_no.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String tradeNo;
        try {
            while ((tradeNo=reader.readLine()) != null) {
                Boss_coupon_status bossStatus = getBossStatus(tradeNo);
                System.out.println(bossStatus.toString());
                writeFile(bossStatus);
//                deleFile(tradeNo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(Boss_coupon_status bs) throws FileNotFoundException, UnsupportedEncodingException {
//        File file = new File("D:\\home\\files\\sql.txt");
//        if (file.exists()) {
//            System.out.println("存在");
//        } else {
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        String sql = "INSERT INTO boss_coupon_status ( ID," +
                " TELEPHONE, TRADE_NO, BATCH_NO, BOSS_GOODS_NO, STATUS, WORK_STATUS, WORK_ID, COUPON_NO, REMARK," +
                " CREATE_TIME, HANDER_TIME ) VALUES (BOSS_COUPON_STATUS_seq.nextval,";
        StringBuilder sb = new StringBuilder();
        sb.append("'"+bs.getTelephone()+"',");
        sb.append("'"+bs.getTrade_no()+"',");
        sb.append(bs.getBatch_no()==null?"null,":"'"+bs.getBatch_no() +"',");
        sb.append(bs.getBoss_goodsNo()==null?"null,":"'"+bs.getBoss_goodsNo()+",");
        sb.append("2,");
        sb.append(bs.getWork_status()==null?"null,":"'"+bs.getWork_status()+"',");
        sb.append(bs.getWork_id()==null?"null,":"'"+bs.getWork_id()+"',");
        sb.append(bs.getCoupon_no()==null?"null,":"'"+bs.getCoupon_no()+"',");
        sb.append("null,systimestamp,systimestamp);");
        String str = sb.toString();
        String s = sql + str;
        try {
            output.write(s);
            output.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleFile(String trano) {
        String sql = "DELETE from  BOSS_COUPON_STATUS where TRADE_NO = '"+trano+"',and STATUS = 2;";
        try {
            output.write(sql);
            output.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private BufferedWriter output;
    @Before
    public void initOutFile() {
        File file = new File("D:\\home\\files\\sql.txt");
        if (file.exists()) {
            System.out.println("存在");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         try {
            output =  new BufferedWriter(new FileWriter(file,true));//true,则追加写入text文本
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void outFile() throws IOException {
        output.flush();
        output.close();
    }
    @Test
    public void testExport() throws FileNotFoundException, UnsupportedEncodingException {
        exportSql();
//        writeFile();
    }
    @Test
    public void listSystemInfo() {
        Properties properties = System.getProperties();
        properties.list(System.out);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}