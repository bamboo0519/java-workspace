package top.ibamboo.practice.design.patten.factory.easy;

import lombok.Setter;

/**
 * Created by C0907 on 2017/8/21.
 */
@Setter
public class AccountEasy {
    int a;

    public static void main(String[] args) {
        AccountEasy account = new AccountEasy();
        account.setA(5);


    }
}
