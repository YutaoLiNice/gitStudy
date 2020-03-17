package Mybatis.MyMapperScan;

import java.lang.reflect.Proxy;

public class MySession {

    public static Object queryMapper(Class clazz){
        Class cla[]=new Class[]{clazz};
       Object proxy= Proxy.newProxyInstance(MySession.class.getClassLoader(),cla,new MyInvocationHandler());
       return proxy;
    }
}
