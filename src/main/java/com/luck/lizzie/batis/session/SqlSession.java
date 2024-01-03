package com.luck.lizzie.batis.session;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 09:20
 * @PackageName: com.luck.lizzie.batis.session
 * @ClassName: SqlSession
 * @Version 1.0
 */
public interface SqlSession {

    /**
     * @param statement sql statement
     * @param parameter 参数
     * @param <T>       type
     * @return result
     */
    <T> T selectOne(String statement, Object... parameter);

    /**
     * 获取或创建对应的Mapper
     *
     * @param type 支撑的接口类型
     * @param <T>  接口泛型
     * @return Mapper
     */
    <T> T getMapper(Class<T> type);

}
