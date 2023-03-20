package Mybatis.MyMapperScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("Mybatis.MyMapperScan")
//@ImportResource("classpath:spirng.xml")
//@ImportResource("classpath:spirng.xml")
//@Import(Mybatis.MyMapperScan.MyImportBeanDefinitionRegistrar.class)
//@MapperScan("com.bdqn.lyrk.ssm.study.app.mapper") //扫描Mybatis的Mapper接口
//可以给他添加value 属性配置扫描的包 挨个循环包下的mapper类
@MyScan("Mybatis.MyMapperScan.dao")
public class AppConfig1 { }

  /* @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("xxx");
        dataSource.setUrl("xxx");
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(Log4jImpl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }*/