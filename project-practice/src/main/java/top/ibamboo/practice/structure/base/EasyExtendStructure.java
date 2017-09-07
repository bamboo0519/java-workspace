package top.ibamboo.practice.structure.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by C0907 on 2017/8/24.
 */
@Service
public class EasyExtendStructure{
    @Autowired
    Car car;

    @Autowired(required = false)
    ComponentFace face;

    public int speedUp(){
        if (face == null) {
            face = new ComponentFace() {
            };
        }

        car.speed= 30;

        String res = face.handle("red");
        if("add".equals(res)){
            return car.run(10);
        }else{
            return car.run(0);
        }

    }

}
