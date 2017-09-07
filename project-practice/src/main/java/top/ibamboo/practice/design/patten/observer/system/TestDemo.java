package top.ibamboo.practice.design.patten.observer.system;

import top.ibamboo.account.model.Account;

/**
 * Created by C0907 on 2017/8/30.
 */
public class TestDemo {
    public static void main(String[] args) {

        AccountManager sm = new AccountManager();
        AccountObserver1 a = new AccountObserver1(sm);
        AccountObserver2 b = new AccountObserver2(sm);
        sm.delete(new Account());

        sm.deleteObserver(a);//注销观察者，以后被观察者有数据变化就不再通知这个已注销的观察者
        sm.delete(new Account());

    }
}
