package top.ibamboo.practice.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import top.ibamboo.practice.h2.classproperty.AccountExtService;

/**
 * Created by bamboo on 2017/8/29.
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"top.ibamboo.practice.h2",
                               "top.ibamboo.account"})
public class H2Application {
    @Autowired
    AccountExtService accountExtService;

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(H2Application.class);
        application.run(args);
    }

}
