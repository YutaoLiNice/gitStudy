package Mybatis.MyMapperScan;

import Mybatis.MyMapperScan.tools.AllClassInPkg;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Iterator;
import java.util.Set;

//把一个类交给spring管理
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        String pkg="";
        Set set=null;
        boolean hasAnnotation=  AppConfig1.class.isAnnotationPresent(MyScan.class);
        if(hasAnnotation){
            MyScan myScan=   AppConfig1.class.getAnnotation(MyScan.class);
            pkg= myScan.value()[0];
        }
        if(!pkg.equals("")&&pkg!=null) {
             set = AllClassInPkg.getClasses(pkg);
        }

        if(set.size()>0){
            Iterator<Class> iterator = set.iterator();
             while(iterator.hasNext()){
                Class clazz= iterator.next();
                 BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyMapperFactoryBean.class);
                 AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

               // beanDefinition.getPropertyValues().add("mapperInterface","Mybatis.MyMapperScan.dao.TDao");
                 beanDefinition.getPropertyValues().add("mapperInterface",clazz.getName());

                 //beanDefinitionRegistry.registerBeanDefinition("tDao",beanDefinition);
                 //截取类名设置为bean的名字
                String beanName= AllClassInPkg.lowerFirstChar(clazz.getSimpleName());
                 beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinition);

             }
        }
        //下面以构造器的形式向factorybean传参
      /*  GenericBeanDefinition beanDefinition = (GenericBeanDefinition)builder.getBeanDefinition();
        //        //因为factoryBean.getObject方法返回的是代理对象，所以我们需要将TestMapper.class传进去
        //        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(TestMapper.class.getName());
        //        //动态修改beanClass为FactoryBean
        //        beanDefinition.setBeanClass(MyFactoryBean.class);
        //        //将beanDefinition注册到spring容器中*/


    }
}
