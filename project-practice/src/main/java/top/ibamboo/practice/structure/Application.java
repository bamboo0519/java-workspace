package top.ibamboo.practice.structure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import top.ibamboo.practice.structure.base.ApplicationContextHandle;
import top.ibamboo.practice.structure.base.Car;
import top.ibamboo.practice.structure.base.ComponentFace;
import top.ibamboo.practice.structure.base.EasyExtendStructure;

import java.util.Map;

/**
 * Created by bamboo on 2017/8/24.
 */


@ComponentScan(basePackages = {"top.ibamboo.practice.structure"})
@SpringBootApplication
public class Application {
    @Autowired
    EasyExtendStructure easyExtendStructure;

    @Autowired
    Car car;

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);

        Application bean =  (Application) ApplicationContextHandle.getBean("application");
        System.out.println("test~~" + bean+ "  "+ bean.toString());

        bean.easyExtendStructure.speedUp();

        Map<String, ComponentFace> map =  (Map<String, ComponentFace>)ApplicationContextHandle.getBean(ComponentFace.class);
        for(String key : map.keySet()){
            System.out.println("test1~~" + map.get(key)+ " "+key+":  ");
        }

        for(String name : ApplicationContextHandle.getApplicationContext().getBeanDefinitionNames()){
            System.out.println("getBeanDefinitionNames: "+name);
            System.out.println("----Bean class: "+ApplicationContextHandle.getBean(name).getClass());
        }


    }
}
