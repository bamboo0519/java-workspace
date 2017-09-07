import org.junit.Test;
import top.ibamboo.account.model.Account;
import top.ibamboo.practice.serialize.JsonPractice;

/**
 * Created by C0907 on 2017/9/7.
 */

public class JsonPracticeTest {

    public Account createAccout() {
        Account account = new Account();
        account.setAccountId("10000");
        account.setAccountName("test");
        account.setEmail("10000@dtdream.com");
        account.setMobile("13088888888");

        return account;
    }
    @Test
    public void test(){
        JsonPractice jsonPractice = new JsonPractice();

        System.out.println(jsonPractice.toJson(createAccout()));
    }
}
