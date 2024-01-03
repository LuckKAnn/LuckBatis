package com.luck.lizzie.batis.session;

/**
 * 该类封装了查询数据库的一些列操作，如selectOne(),update(),getMapper() 等，
 *
 * @Author liukun.inspire
 * @Date 2024/1/3 09:20
 * @PackageName: com.luck.lizzie.batis.session
 * @ClassName: SqlSession
 * @Version 1.0
 */
public interface SqlSession {

    /**
     * Retrieve a single row mapped from the statement key and parameter.
     * 根据指定的SqlID获取一条记录的封装对象，只不过这个方法容许我们可以给sql传递一些参数
     * 一般在实际使用中，这个参数传递的是pojo，或者Map或者ImmutableMap
     *
     * @param <T>       the returned object type
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement.
     * @return Mapped object
     */
    <T> T selectOne(String statement, Object parameter);

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
