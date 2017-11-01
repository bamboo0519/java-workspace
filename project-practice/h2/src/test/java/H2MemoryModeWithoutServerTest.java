import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.ibamboo.account.dao.AccountDao;
import top.ibamboo.account.model.Account;
import top.ibamboo.practice.h2.H2Application;

import java.util.List;

/**
 * Created by bamboo on 2017/8/29.
 *
 * 直接在内存中创建h2数据库，不需要H2服务器支持
 * 该测试使用到了resource:db/*; resource:mapper/*
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = H2Application.class)
public class H2MemoryModeWithoutServerTest {
    @Autowired
    AccountDao accountDao;

    public Account createAccount(){
        Account account = new Account();
        account.setAccountId("123");
        account.setAccountName("222");
        account.setEmail("22@22");
        account.setMobile("1234567890");
        account.setPassword("123456");

        return account;
    }


    @Test
    public void test(){
        boolean result = accountDao.create(createAccount());
        System.out.println("test result: "+result);

        List<Account> accountList = accountDao.listAll();
        log.info("accountList:{}",accountList.get(0));
    }
}
