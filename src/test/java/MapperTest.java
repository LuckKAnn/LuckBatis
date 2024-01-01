import com.luck.lizzie.batis.binding.MapperProxy;
import com.luck.lizzie.batis.binding.MapperProxyFactory;
import org.junit.Test;
import service.IUserDao;

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
        IUserDao iUserDao = mapperProxyFactory.newInstance(session);
        System.out.println(iUserDao.queryUserInfo("assaas"));
        System.out.println(iUserDao.hashCode());
    }
}
