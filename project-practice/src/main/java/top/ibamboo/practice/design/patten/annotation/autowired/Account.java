package top.ibamboo.practice.design.patten.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by C0907 on 2017/8/18.
 */

@Component
public class Account {
    private String name;
    private String password;


    private Category category;
    private Role role;

    @Autowired
    public Account(Category category ,Role role){
        this.category = category;
        this.role = role ;
    }

    public Account lendCategory(Category category){
        this.category = category;
        return this;
    }


}
