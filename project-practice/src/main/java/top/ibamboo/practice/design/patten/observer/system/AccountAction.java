package top.ibamboo.practice.design.patten.observer.system;

/**
 * Created by bamboo on 2017/8/30.
 */
public enum AccountAction {
    DELETE(1, "delete");

    AccountAction(int action, String type) {
        this.action = action;
        this.type = type;
    }

    int action;
    String type;
}
