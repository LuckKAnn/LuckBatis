package com.luck.lizzie.batis.session;

import com.luck.lizzie.batis.builder.xml.XMLConfigBuilder;
import com.luck.lizzie.batis.session.defaults.DefaultSqlSessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;

import java.io.Reader;

/**
 * @Author liukun.inspire
 * @Date 2024/1/3 10:13
 * @PackageName: com.luck.lizzie.batis.session
 * @ClassName: SqlSessionFactoryBuilder
 * @Version 1.0
 */
@Slf4j
public class SqlSessionFactoryBuilder {
    public static SqlSessionFactory build(Reader reader) {
        // 读取XML
        Configuration configuration = new Configuration();
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(configuration);
        try {
            xmlConfigBuilder.parse(reader);
        } catch (Exception e) {
            log.error("parse xml config wrong ", e);
            throw new RuntimeException(e);
        }
        return build(configuration);
    }

    public static SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }
}
