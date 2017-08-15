package top.ibamboo.java.practice.proxy.cglib;

import org.junit.Test;

/**
 * Created by C0907 on 2017/8/15.
 */
public class Tester {
    @Test
    public void test(){
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new CglibProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
