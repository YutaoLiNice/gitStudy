package Mybatis.MyMapperScan;

import Mybatis.MyMapperScan.jdbc.TestUseJdbcTemplete;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Select name=method.getAnnotation(Select.class);
        if(name!=null){
            String s= name.value()[0];
           // TestUseJdbcTemplete.test();
            TestUseJdbcTemplete.queryBySql(s);
            //可以在此处得到注解上面的sql语句，可以在此增加jdbc，对数据进行操作
        }
        if(method.getName().equals("toString")){
            System.out.println(proxy.getClass().getInterfaces()[0].getName());
            return  proxy.getClass().getInterfaces()[0].getName();
        }
        return null;
    }
}
