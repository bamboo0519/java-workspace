package top.ibamboo.practice.listbean;

import org.springframework.stereotype.Component;

/**
 * Created by bamboo on 2017/8/21.
 */
@Component
public class BeanEntity2 implements Naming {
    @Override
    public String naming(String name){
        return name + ".csv";
    }
}
