package top.ibamboo.practice.design.patten.factory.easy;

import lombok.Data;

/**
 * Created by bamboo on 2017/8/21.
 */
@Data
public class AccountEasy {
    int a;

    public static void main(String[] args) {
        AccountEasy account = new AccountEasy();
        account.a = 5;


    }
}
