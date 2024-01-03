package com.luck.lizzie.batis.session.defaults;

import com.luck.lizzie.batis.binding.MapperRegistry;
import com.luck.lizzie.batis.session.Configuration;
import com.luck.lizzie.batis.session.SqlSession;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 09:22
 * @PackageName: com.luck.lizzie.batis.session.defaults
 * @ClassName: DefaultSqlSession
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {


    private Configuration configuration;

    public DefaultSqlSession() {
    }

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter + "\n" + "sql 语句:" + configuration.getMappedStatement(statement).getSql());
    }

    @Override
    public <T> T selectOne(String statement, Object... parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter + "\n" + "sql 语句:" + configuration.getMappedStatement(statement).getSql());
    }


    @Override
    public <T> T getMapper(Class<T> type) {
        return (T) configuration.getMapperRegistry().getMapper(type, this);
    }
}
