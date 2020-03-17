package Mybatis.MyMapperScan;

import Mybatis.MyMapperScan.mapper.TDao;
import Mybatis.MyMapperScan.mapper.TDaoTwo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext a=new AnnotationConfigApplicationContext();
        a.register(AppConfig1.class);
        a.refresh();
        //MySession相当于sqlsession
        TDao tDao      =   (TDao)MySession.queryMapper(TDao.class);
        TDaoTwo tDaoTwo=  (TDaoTwo)MySession.queryMapper(TDaoTwo.class);
        //相像这个地方在service的方法里
        tDao.list();
        tDaoTwo.query();
        //tDao.toString();

    }
}
