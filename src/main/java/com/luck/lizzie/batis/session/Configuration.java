package com.luck.lizzie.batis.session;

import com.luck.lizzie.batis.binding.MapperRegistry;
import com.luck.lizzie.batis.mapping.MappedStatement;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 10:13
 * @PackageName: com.luck.lizzie.batis.session
 * @ClassName: Configuration
 * @Version 1.0
 */
@Slf4j
public class Configuration {

    private MapperRegistry mapperRegistry = new MapperRegistry();

    private Map<String, MappedStatement> mappedStatementMap = new HashMap<>();


    public MappedStatement getMappedStatement(String statementKey) {
        if (!mappedStatementMap.containsKey(statementKey)) {
            log.error("Can not find target MappedStatement for key :{}", statementKey);
            throw new RuntimeException();
        }
        return mappedStatementMap.get(statementKey);
    }

    public <T> T getMapper(Class<T> clazz, SqlSession sqlSession) {
        return mapperRegistry.getMapper(clazz, sqlSession);
    }

    public <T> void addMapper(Class<T> clazz) {
        mapperRegistry.addMapper(clazz);
    }


    public void addMappedStatement(MappedStatement ms) {
        this.mappedStatementMap.put(ms.getKey(), ms);
    }

    public MapperRegistry getMapperRegistry() {
        return mapperRegistry;
    }
}
