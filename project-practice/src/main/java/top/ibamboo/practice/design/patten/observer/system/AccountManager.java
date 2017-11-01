package top.ibamboo.practice.design.patten.observer.system;


import lombok.extern.slf4j.Slf4j;
import top.ibamboo.account.model.Account;

import java.util.Observable;

/**
 * Created by bamboo on 2017/8/30.
 */
@Slf4j
public class AccountManager extends Observable {

    public String getData(){
        return "123456";
    }

    public void delete(Account account){
        System.out.println("delete account: {}"+account);

        setChanged();
        notifyObservers(AccountAction.DELETE);  //只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。  }
    }
}
