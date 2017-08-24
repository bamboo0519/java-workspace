package top.ibamboo.practice.listbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

/**
 * Created by C0907 on 2017/8/21.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"top.ibamboo.practice.listbean"})
public class TestApplication {
    @Autowired
    public BeanEntity beanEntity;

    public BeanEntity getAbcdBeanEntity(){
        return beanEntity;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TestApplication.class);
        application.run(args);

        BeanEntity beanEntity =  (BeanEntity)ApplicationContextHandle.getBean("beanEntity");
        System.out.println("test~~" + beanEntity+ "  "+ beanEntity.getDefaultName());

        Map<String, Naming> map =  (Map<String, Naming>)ApplicationContextHandle.getBean(Naming.class);
        for(String key : map.keySet()){
            System.out.println("test1~~" + map.get(key)+ " "+key+":  "+map.get(key).naming("123"));
        }

        System.out.println("test~~" + new TestApplication().getAbcdBeanEntity());

        for(String name : ApplicationContextHandle.getApplicationContext().getBeanDefinitionNames()){
            System.out.println("getBeanDefinitionNames: "+name);
            System.out.println("    Bean class: "+ ApplicationContextHandle.getBean(name).getClass());
        }
    }
}
