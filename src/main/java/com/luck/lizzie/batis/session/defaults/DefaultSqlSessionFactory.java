package com.luck.lizzie.batis.session.defaults;

import com.luck.lizzie.batis.binding.MapperRegistry;
import com.luck.lizzie.batis.session.Configuration;
import com.luck.lizzie.batis.session.SqlSession;
import com.luck.lizzie.batis.session.SqlSessionFactory;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 09:22
 * @PackageName: com.luck.lizzie.batis.session.defaults
 * @ClassName: DefaultSqlSession
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
