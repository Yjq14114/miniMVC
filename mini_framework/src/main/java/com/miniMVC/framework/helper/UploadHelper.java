package com.miniMVC.framework.helper;

import com.miniMVC.commons.CollectionUtil;
import com.miniMVC.commons.FileUtil;
import com.miniMVC.commons.StreamUtil;
import com.miniMVC.commons.StringUtil;
import com.miniMVC.framework.ConfigHelper;
import com.miniMVC.framework.bean.FileParam;
import com.miniMVC.framework.bean.FormParam;
import com.miniMVC.framework.bean.Param;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yjq14 on 2018/3/31.
 */
public final class UploadHelper {
    private static final Logger logger = LoggerFactory.getLogger(UploadHelper.class);
    private static ServletFileUpload servletFileUpload;

    public static void init(ServletContext servletContext) {
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
        servletFileUpload = new ServletFileUpload(new DiskFileItemFactory(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD, repository));
        int uploadLimit = ConfigHelper.getAppUploadLimit();
        if (uploadLimit != 0) {
            servletFileUpload.setFileSizeMax(uploadLimit * 1024 * 1024);
        }
    }

    /**
     * 判断请求是否为multipart类型
     * @param request
     * @return
     */
    public static boolean isMultipart(HttpServletRequest request) {
        return ServletFileUpload.isMultipartContent(request);
    }
    public static boolean isMultipartFormData(HttpServletRequest request) {
        String contentType = request.getContentType();
        return ServletFileUpload.isMultipartContent(request) || contentType.equalsIgnoreCase(ServletFileUpload.MULTIPART_FORM_DATA);
    }
    public static Param createParam(HttpServletRequest  request) {
        List<FormParam> formParamList = new ArrayList<>();
        List<FileParam> fileParamList = new ArrayList<>();
        try {
            Map<String, List<FileItem>> fileItemListMap = servletFileUpload.parseParameterMap(request);
            if (CollectionUtil.isNotEmpty(fileItemListMap)) {
                for (Map.Entry<String, List<FileItem>> fileItemListEntry: fileItemListMap.entrySet()) {
                    String fieldName = fileItemListEntry.getKey();
                    List<FileItem> fileItemList = fileItemListEntry.getValue();
                    if (CollectionUtil.isNotEmpty(fileItemList)) {
                        for (FileItem item: fileItemList) {
                            if (item.isFormField()) {
                                String fieldValue= item.getString("UTF-8");
                                formParamList.add(new FormParam(fieldName, fieldValue));
                            } else {
                                String fileName = FileUtil.getRealFileName(new String(item.getName().getBytes(), "UTF-8"));
                                if (StringUtil.isNotEmpty(fieldName)) {
                                    long size = item.getSize();
                                    String contentType = item.getContentType();
                                    InputStream inputStream = item.getInputStream();
                                    fileParamList.add(new FileParam(fieldName, fileName, size, contentType, inputStream));
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileUploadException | IOException e) {
            logger.error("create param failure", e);
            throw new RuntimeException(e);
        }
        return new Param(formParamList, fileParamList);
    }
    public static void uploadFile(String basePath, FileParam fileParam) {
        try {
            if (fileParam != null) {
                String filePath = basePath + fileParam.getFileName();
                FileUtil.createFile(filePath);
                InputStream inputStream = new BufferedInputStream(fileParam.getInputStream());
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
                StreamUtil.copyStream(inputStream, outputStream);
            }
        } catch (Exception e) {
            logger.error("upload file failure", e);
            throw new RuntimeException(e);
        }
    }
    public static void uploadFile(String bashPath, List<FileParam> fileParamList) {
        try {
            if (CollectionUtil.isNotEmpty(fileParamList)) {
                for (FileParam param: fileParamList) {
                    uploadFile(bashPath, param);
                }
            }
        } catch (Exception e) {
            logger.error("upload file failure", e);
            throw new RuntimeException(e);
        }
    }
}
