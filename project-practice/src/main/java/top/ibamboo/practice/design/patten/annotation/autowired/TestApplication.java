package top.ibamboo.practice.design.patten.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * Created by C0907 on 2017/8/18.
 */
@EnableScheduling
@SpringBootApplication()
@ComponentScan(basePackages = {"top.ibamboo.practice.design.patten.annotation.autowired"})
public class TestApplication {
    @Autowired
    Account account;

    private static int index = 0;

    @Scheduled(fixedDelay = 1000 * 2)
    public void test(){
        System.out.println(new Date()+" test: "+ index++);
//        ContextLoader

    }



    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TestApplication.class);
        application.run(args);

    }
}
