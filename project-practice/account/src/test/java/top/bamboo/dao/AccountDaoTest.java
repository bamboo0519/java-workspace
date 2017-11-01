package top.bamboo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.bamboo.AccountApplication;

/**
 * Created by bamboo on 2017/11/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AccountApplication.class)
@ActiveProfiles("scratch")
public class AccountDaoTest {
    @Test
    public void test() {
        //TODO    CL ~~~~~~~
    }
}
