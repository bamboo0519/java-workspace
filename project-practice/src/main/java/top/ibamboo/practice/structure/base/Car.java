package top.ibamboo.practice.structure.base;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by bamboo on 2017/8/24.
 */
@Component
@Data
public class Car {
    int speed;
    String color;

    int run(int a){
        int resultSpeed = speed + a;
        System.out.println("Now speed is "+resultSpeed);
        return resultSpeed;
    }
}
