package top.ibamboo.practice.design.patten.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by bamboo on 2017/8/15.
 */
public class CglibProxyFactory implements MethodInterceptor {
    //维护目标对象
    private Object target;

    private IProxyHandler iProxyHandler = new IProxyHandler() {};

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();

    }
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        iProxyHandler.proxyPreHandle(args);

        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);

        iProxyHandler.proxyPostHandle(returnValue,args);

        return returnValue;
    }

    public CglibProxyFactory withProxyHandler(IProxyHandler iProxyHandler) {
        if(iProxyHandler != null) {
            this.iProxyHandler = iProxyHandler;
        }

        return this;
    }
}
