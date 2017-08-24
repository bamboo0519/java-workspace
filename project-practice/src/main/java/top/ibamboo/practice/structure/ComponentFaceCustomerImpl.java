package top.ibamboo.practice.structure;

import org.springframework.stereotype.Component;
import top.ibamboo.practice.structure.base.ComponentFace;

/**
 * Created by C0907 on 2017/8/24.
 */

// @Primary 为方案一的实现
//@Primary
@Component
public class ComponentFaceCustomerImpl implements ComponentFace {

    @Override
    public String handle(String type){
        return "add";
    }
}
