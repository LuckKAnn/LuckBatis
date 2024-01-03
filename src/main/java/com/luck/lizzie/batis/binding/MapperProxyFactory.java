package com.luck.lizzie.batis.binding;

import cn.hutool.core.util.ClassLoaderUtil;
import com.luck.lizzie.batis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2024/1/1 17:42
 * @PackageName: com.luck.lizzie.batis.binding
 * @ClassName: MapperProxyFactory
 * @Version 1.0
 */
public class MapperProxyFactory<T> {
    private Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * factory design model . create MapperProxy Only,
     *
     * @param sqlSession sqlSession
     * @return proxy target
     * @see MapperProxy
     */
    public T newInstance(SqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(ClassLoaderUtil.getClassLoader(),
                new Class[]{mapperInterface},
                new MapperProxy<T>(sqlSession, mapperInterface));
    }
}
