package com.luck.lizzie.batis.binding;

import com.luck.lizzie.batis.session.SqlSession;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2024/1/1 17:41
 * @PackageName: com.luck.lizzie.batis.binding
 * @ClassName: MapperProxy
 * @Version 1.0
 */
@Slf4j
public class MapperProxy<T> implements InvocationHandler {

    private SqlSession sqlSession;

    private Class<T> clazz;

    public MapperProxy(SqlSession sqlSession, Class<T> clazz) {
        this.sqlSession = sqlSession;
        this.clazz = clazz;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            log.info("native method involved");
            // 这里直接带哦用invoke proxy的话会导致循环的调用
            return method.invoke(this, args);
        } else {
            // 代理方法
            log.info("Proxy Method has invoked , className:{}, methodName:{}", clazz.getName(), method.getName());
            return sqlSession.selectOne(clazz.getName() + "." + method.getName(), args);
        }
    }
}
