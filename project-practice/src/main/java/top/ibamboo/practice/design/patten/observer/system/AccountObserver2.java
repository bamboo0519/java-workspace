package top.ibamboo.practice.design.patten.observer.system;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by C0907 on 2017/8/30.
 */
public class AccountObserver2 implements Observer {
    public AccountObserver2(AccountManager sm) {
        super();
        sm.addObserver(this);//注册加入观察者
    }

    @Override
    public void update(Observable observable, Object obj) {
        System.out.println("Observer2 receive:Data has changed to "+((AccountManager) observable).getData());

    }

}
