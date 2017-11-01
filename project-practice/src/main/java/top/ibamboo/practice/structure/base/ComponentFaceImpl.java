package top.ibamboo.practice.structure.base;

/**
 * Created by bamboo on 2017/8/24.
 */
/**
 *   定义为Component，则是方案一，否则为方案二的实现
 */
//@Component
public class ComponentFaceImpl implements ComponentFace{

    @Override
    public String handle(String type) {
        return "add";
    }
}
