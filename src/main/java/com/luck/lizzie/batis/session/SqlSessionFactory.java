package com.luck.lizzie.batis.session;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 09:20
 * @PackageName: com.luck.lizzie.batis.session
 * @ClassName: SqlSessionFactory
 * @Version 1.0
 */
public interface SqlSessionFactory {

    /**
     * @return session
     */
    SqlSession openSession();
}

