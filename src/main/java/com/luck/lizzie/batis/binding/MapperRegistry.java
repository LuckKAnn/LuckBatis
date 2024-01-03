package com.luck.lizzie.batis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.luck.lizzie.batis.session.SqlSession;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 09:19
 * @PackageName: com.luck.lizzie.batis.binding
 * @ClassName: MapperRegistry
 * @Version 1.0
 */
@Slf4j
public class MapperRegistry {


    private Map<Class<?>, MapperProxyFactory<?>> mapperProxyFactoryMap = new HashMap<>();


    public <T> void addMapper(Class<T> clazz) {
        if (mapperProxyFactoryMap.containsKey(clazz)) {
            log.error("MapperRegistry  can not registry a mapper twice");
            return;
        }
        MapperProxyFactory<T> mapperProxyFactory = new MapperProxyFactory<>(clazz);
        mapperProxyFactoryMap.put(clazz, mapperProxyFactory);
        return;
    }

    public void addMapper(String basePackage) {
        Set<Class<?>> potentialClazzs = ClassScanner.scanPackage(basePackage);
        for (Class<?> potentialClazz : potentialClazzs) {
            if (!potentialClazz.isInterface()) {
                continue;
            }
            addMapper(potentialClazz);
        }
    }

    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession) {
        MapperProxyFactory<?> mapperProxyFactory = mapperProxyFactoryMap.get(clazz);

        if (mapperProxyFactory == null) {
            log.error("Can not find target MapperProxyFactory for Clazz :{}", clazz.getName());
            throw new RuntimeException();
        }

        try {
            return (T) mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            log.error("Create mapper fail", e);
            throw new RuntimeException();
        }
    }

}
