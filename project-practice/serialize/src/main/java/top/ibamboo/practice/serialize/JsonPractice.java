package top.ibamboo.practice.serialize;

import com.google.gson.Gson;
import top.ibamboo.account.model.Account;

/**
 * Created by C0907 on 2017/9/7.
 */
public class JsonPractice {



    public String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

}
