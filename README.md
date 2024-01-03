# LuckBatis

rewrite of mybatis framework

# 核心类解析

# SqlSession

- SqlSession 可以抽象为数据库的会话，每次执行依赖于一个SqlSession，SqlSession也是对应Mapper接口代理类的核心实现逻辑
- MapperRegistry 完成对应的MapperProxyFactory的加载(包扫描),但是以懒加载的方式创建实际的Mapper

