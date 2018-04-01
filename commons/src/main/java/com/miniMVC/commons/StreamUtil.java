package com.miniMVC.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Created by yjq14 on 2018/3/4.
 */
public final class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    public static String getString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            LOGGER.error("get string failure", e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void copyStream(InputStream is, OutputStream os) {
        try {
            int length;
            byte[] buffer = new byte[4 * 1024];
            while ((length=is.read(buffer, 0, buffer.length)) != -1) {
                os.write(buffer, 0, length);
            }
            os.flush();
        } catch (IOException e) {
            LOGGER.error("copy stream failure", e);
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                LOGGER.error("close stream failure", e);
            }
        }
    }
}
