package top.ibamboo.practice.structure.base;

/**
 * Created by bamboo on 2017/8/24.
 */
public interface ComponentFace {

    default String handle(String type) {
        return null;
    }

}
