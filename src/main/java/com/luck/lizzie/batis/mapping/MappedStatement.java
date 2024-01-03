package com.luck.lizzie.batis.mapping;

import com.luck.lizzie.batis.session.Configuration;
import lombok.Data;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 10:12
 * @PackageName: com.luck.lizzie.batis.mapping
 * @ClassName: MappedStatement
 * @Version 1.0
 */
public class MappedStatement {

    private String key;

    private Class<?> parameterType;

    private SqlCommandType sqlCommandType;

    private Class<?> mapperClass;

    private Configuration configuration;

    private Class<?> resultType;

    private String sql;

    public String getKey() {

        return key;
    }

    /**
     * @param key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    public Class<?> getParameterType() {
        return parameterType;
    }

    /**
     * @param parameterType to set
     */
    public void setParameterType(Class<?> parameterType) {
        this.parameterType = parameterType;
    }

    public Class<?> getResultType() {
        return resultType;
    }

    /**
     * @param resultType to set
     */
    public void setResultType(Class<?> resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    /**
     * @param sql to set
     */
    public void setSql(String sql) {
        this.sql = sql;

    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    /**
     * @param sqlCommandType to set
     */
    public void setSqlCommandType(SqlCommandType sqlCommandType) {
        this.sqlCommandType = sqlCommandType;
    }

    public Class<?> getMapperClass() {
        return mapperClass;
    }

    /**
     * @param mapperClass to set
     */
    public void setMapperClass(Class<?> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    /**
     * @param configuration to set
     */
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
