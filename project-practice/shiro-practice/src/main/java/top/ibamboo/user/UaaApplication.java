package top.ibamboo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bamboo on 2017/8/28.
 */
@Controller
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"top.ibamboo.user.C.filter",
                                "top.ibamboo.user",
                               "top.ibamboo.account"})
public class UaaApplication {
    @RequestMapping({"/"})
    public String  home() {
        System.out.print("UaaApplication~~");

        return "login/login";
    }

    public static void main (String[] args) {
        SpringApplication application = new SpringApplication(UaaApplication.class);
        application.run(args);
    }
}
