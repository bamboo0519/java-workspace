package hello;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@EnableScheduling
@RestController
@SpringBootApplication
public class SayHelloApplication {
    private static Logger log = LoggerFactory.getLogger(SayHelloApplication.class);
    int index = 0;

    @RequestMapping(value = "/greeting")
    public String greet() {
        log.info("Access /greeting");

        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

    @RequestMapping(value = "/")
    public String home() {
        log.info("Access /");
        return "Hi!";
    }

    //@Scheduled(fixedDelay = 1000 * 2)
    public void test(){
        System.out.println(new Date()+" test: "+ index++);


    }
    public static void main(String[] args) {
        SpringApplication.run(SayHelloApplication.class, args);


    }
}
