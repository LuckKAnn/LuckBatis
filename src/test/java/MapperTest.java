import com.luck.lizzie.batis.binding.MapperProxy;
import com.luck.lizzie.batis.binding.MapperProxyFactory;
import com.luck.lizzie.batis.binding.MapperRegistry;
import com.luck.lizzie.batis.io.Resources;
import com.luck.lizzie.batis.session.Configuration;
import com.luck.lizzie.batis.session.SqlSession;
import com.luck.lizzie.batis.session.SqlSessionFactory;
import com.luck.lizzie.batis.session.SqlSessionFactoryBuilder;
import com.luck.lizzie.batis.session.defaults.DefaultSqlSession;
import com.luck.lizzie.batis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import service.IOrderDao;
import service.IUserDao;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2024/1/1 17:52
 * @PackageName: PACKAGE_NAME
 * @ClassName: MapperTest
 * @Version 1.0
 */
public class MapperTest {

    @Test
    public void testMapperProxyFactory() {
        Map<String, String> session = new HashMap<>();
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);
        IUserDao iUserDao = mapperProxyFactory.newInstance(new DefaultSqlSession());
        System.out.println(iUserDao.queryUserInfo("assaas"));
        System.out.println(iUserDao.hashCode());
    }

    @Test
    public void testRegistryMapper() {
        Configuration configuration = new Configuration();
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        MapperRegistry mapperRegistry = defaultSqlSessionFactory.getConfiguration().getMapperRegistry();
        mapperRegistry.addMapper("service");
        SqlSession sqlSession = defaultSqlSessionFactory.openSession();
        // sqlSession.selectOne("sdqdqw");
        IOrderDao mapper = sqlSession.getMapper(IOrderDao.class);
        System.out.println(mapper.queryOrderById(111L));
    }


    @Test
    public void testBuildSqlSessionFactory() {
        InputStreamReader inputStreamReader = Resources.loadResourceReader("mybatis-config-datasource.xml");
        SqlSessionFactory defaultSqlSessionFactory = SqlSessionFactoryBuilder.build(inputStreamReader);

        SqlSession sqlSession = defaultSqlSessionFactory.openSession();

        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        System.out.println(mapper.queryUserInfo("111"));

    }
}
