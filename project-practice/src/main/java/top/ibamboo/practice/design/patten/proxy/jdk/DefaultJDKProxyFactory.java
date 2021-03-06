package top.ibamboo.practice.design.patten.proxy.jdk;

/**
 * Created by bamboo on 2017/8/15.
 */
public class DefaultJDKProxyFactory extends JDKProxyFactory {

    public DefaultJDKProxyFactory(Object target){
        super(target);
    }

    @Override
    public Object proxyPreHandle(Object... args){
        System.out.println("proxyPreHandle"+args);
        return null;
    }

    @Override
    public Object proxyPostHandle(Object... args){
        System.out.println("proxyPreHandle"+args);
        return null;
    }
}
