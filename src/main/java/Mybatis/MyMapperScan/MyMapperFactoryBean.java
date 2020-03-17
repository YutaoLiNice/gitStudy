package Mybatis.MyMapperScan;

import Mybatis.MyMapperScan.mapper.TDao;
import org.springframework.beans.factory.FactoryBean;

//@Component 这个注解不能加，否则mapperInterface不能注入

public class MyMapperFactoryBean implements FactoryBean {

    public void setMapperInterface(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    //MapperFactoryBean
    Class mapperInterface;
    @Override
    public Object getObject() throws Exception {

        Object o=  (TDao)MySession.queryMapper(mapperInterface);
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;//不写也可以有结果
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
