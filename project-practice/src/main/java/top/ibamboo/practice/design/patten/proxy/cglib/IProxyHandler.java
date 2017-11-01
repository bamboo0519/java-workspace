package top.ibamboo.practice.design.patten.proxy.cglib;

/**
 * Created by bamboo on 2017/8/17.
 */
public interface IProxyHandler {
    default void proxyPreHandle(Object... args){

    }
    default void proxyPostHandle(Object... args){

    }
}
