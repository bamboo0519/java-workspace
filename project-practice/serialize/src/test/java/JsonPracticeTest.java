import com.mongodb.DBObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import top.ibamboo.account.model.Account;
import top.ibamboo.practice.serialize.JsonPractice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bamboo on 2017/9/7.
 */

@Slf4j
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
    public void test() throws IOException, ClassNotFoundException {
        JsonPractice jsonPractice = new JsonPractice();
        Account account = createAccout();

        System.out.println(jsonPractice.toJson(account));

        Map<String, String> map = new HashMap<>();
        map.put("id","123");
        map.put("name","bamboo");
        map.put("email","");
        map.put("pwd",null);

        System.out.println(jsonPractice.toJson(map));


        System.out.println(jsonPractice.toSerialize(map));

        DBObject object = jsonPractice.toSerialize(account);
        log.info("{}", object.get(Account.class.toString()));
        Account account1 = (Account) jsonPractice.toDeserialize(object, Account.class);

        log.info("{}", account1);

    }
}
