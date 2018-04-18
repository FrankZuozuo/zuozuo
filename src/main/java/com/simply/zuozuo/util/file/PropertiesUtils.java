package com.simply.zuozuo.util.file;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Created by 谭健 on 2018/4/17 0017. 星期二. 10:18.
 * © All Rights Reserved.
 * <p>
 * 读取项目resources根目录下的属性文件
 */

@Slf4j
public class PropertiesUtils {


    /**
     * 读取Properties文件
     *
     * @param fileName 没有后缀的文件名
     */
    public Properties loadWithOutSuffix(@NotBlank String fileName) throws IOException {
        return load(fileName, false);
    }


    /**
     * 读取Properties文件
     *
     * @param fileName 有后缀的文件名
     */
    public Properties loadWithSuffix(@NotBlank String fileName) throws IOException {
        return load(fileName, true);
    }

    private Properties load(@NotBlank String fileName, boolean hasSuffix) throws IOException {
        fileName = hasSuffix ? fileName : fileName + ".properties";
        @Nullable
        InputStream source = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        return new Properties() {
            private static final long serialVersionUID = 4229468934258808296L;

            {
                try {
                    load(source);
                } catch (IOException e) {
                    throw new IOException("文件不存在");
                }
            }
        };
    }

    private static PropertiesUtils propertiesUtils = null;

    private static class InsideSingleton {
        private static PropertiesUtils propertiesUtilsSingleton = new PropertiesUtils();
    }

    private PropertiesUtils() {
    }

    public static PropertiesUtils getInstance() {
        if (propertiesUtils == null) {
            propertiesUtils = PropertiesUtils.InsideSingleton.propertiesUtilsSingleton;
        }
        return propertiesUtils;
    }

}
