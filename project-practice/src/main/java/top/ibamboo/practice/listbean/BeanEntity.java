package top.ibamboo.practice.listbean;

import org.springframework.stereotype.Component;

/**
 * Created by bamboo on 2017/8/21.
 */
@Component
public class BeanEntity implements Naming{
    String name = "bamboo";
    String catogory;

    public String getDefaultName(){
        return name;
    }

    @Override
    public String naming(String name){
        return this.name+"_"+name+".zip";
    }
}
