package top.ibamboo.practice.h2.classproperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.ibamboo.account.dao.AccountDao;

/**
 * Created by bamboo on 2017/9/15.
 *
 */
@Component
public class AccountExtService {
    @Autowired
    AccountExtPoDao accountExtPoDao;
    @Autowired
    AccountDao accountDao;

    public boolean createAccountExt(AccountExtPo accountExtPo){


        return true;
    }

    public AccoutFullDto queryById(String accountId) {
        return accountExtPoDao.loadById(accountId);
    }
}
