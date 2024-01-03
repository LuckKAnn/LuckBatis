package com.luck.lizzie.batis.session.defaults;

import com.luck.lizzie.batis.binding.MapperRegistry;
import com.luck.lizzie.batis.session.SqlSession;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 09:22
 * @PackageName: com.luck.lizzie.batis.session.defaults
 * @ClassName: DefaultSqlSession
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {


    private MapperRegistry mapperRegistry;

    public DefaultSqlSession() {
    }

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public <T> T selectOne(String statement, Object... parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }


    @Override
    public <T> T getMapper(Class<T> type) {
        return (T) mapperRegistry.getMapper(type, this);
    }
}
