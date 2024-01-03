package com.luck.lizzie.batis.io;

import cn.hutool.core.util.ClassUtil;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 11:11
 * @PackageName: com.luck.lizzie.batis.io
 * @ClassName: Resources
 * @Version 1.0
 */
public class Resources {


    public static InputStreamReader loadResourceReader(String path) {
        return new InputStreamReader(loadResource(path));
    }

    public static InputStream loadResource(String path) {
        ClassLoader classLoader = ClassUtil.getClassLoader();
        return classLoader.getResourceAsStream(path);
    }
}
