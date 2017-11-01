package top.ibamboo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bamboo on 2017/10/19.
 */
@Controller
public class TestController {
    @RequestMapping("/2")
    public String loginTest() throws Exception {
        return "login/login";
    }
}
