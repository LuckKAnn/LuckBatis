package com.luck.lizzie.batis.builder;

import com.luck.lizzie.batis.session.Configuration;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 10:13
 * @PackageName: com.luck.lizzie.batis.builder
 * @ClassName: BaseBuilder
 * @Version 1.0
 */
public class BaseBuilder {

    protected Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
