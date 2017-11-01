package top.ibamboo.practice.h2.classproperty;

import top.ibamboo.account.model.Account;

import java.io.Serializable;

/**
 * Created by bamboo on 2017/9/15.
 */
public class AccoutFullDto implements Serializable{
    private static final long serialVersionUID = 1L;
    Account account;
    AccountExtPo accountExtPo;
}
