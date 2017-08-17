package top.ibamboo.java.practice.design.patten.proxy.cglib;

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
        UserDao proxy = (UserDao)new CglibProxyFactory(target).withProxyHandler(new IProxyHandler() {
            @Override
            public void proxyPostHandle(Object... args) {
                System.out.println("后置拦截器");
            }
        }).getProxyInstance();

        //执行代理对象的方法
        proxy.save();

    }
}
