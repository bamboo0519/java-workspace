package top.ibamboo.practice.design.patten.observer.selfdefine;

/**
 * Created by bamboo on 2017/8/30.
 */
public abstract class Observer {
    protected Subject subject;
    public abstract boolean update();
}
