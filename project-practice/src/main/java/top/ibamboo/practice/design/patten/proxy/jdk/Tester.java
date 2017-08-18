package top.ibamboo.practice.design.patten.proxy.jdk;

import org.junit.Test;
import top.ibamboo.practice.design.patten.proxy.IUserDao;
import top.ibamboo.practice.design.patten.proxy.UserDao;

/**
 * Created by C0907 on 2017/8/15.
 */
public class Tester {

    @Test
    public  void test() {
        // 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型 UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new DefaultJDKProxyFactory(target).getProxyInstance();
        // class $Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
    }
}
