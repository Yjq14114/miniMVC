package com.miniMVC.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by yjq14 on 2018/3/31.
 */
public final class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static String getRealFileName(String fileName) {
        return FilenameUtils.getName(fileName);
    }

    public static File createFile(String filePath) {
        File file;
        try {
            file = new File(filePath);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                FileUtils.forceMkdir(parentFile);
            }
        } catch (IOException e) {
            logger.error("create file failure", e);
            throw new RuntimeException(e);
        }
        return file;
    }

}
