package top.ibamboo.practice.design.patten.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by bamboo on 2017/8/15.
 */
public abstract class JDKProxyFactory {
    //维护一个目标对象
    private Object target;
    public JDKProxyFactory(Object target){
        this.target=target;
    }

    public abstract Object proxyPreHandle(Object... args);
    public abstract Object proxyPostHandle(Object... args);

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    proxyPreHandle(method, args);
                    //执行目标对象方法
                    Object returnValue = method.invoke(target, args);
                    proxyPostHandle(method,returnValue,args);
                    return returnValue;
                }
            }
        );
    }
}
