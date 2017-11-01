package top.ibamboo.practice.design.patten.proxy;

/**
 * Created by bamboo on 2017/8/15.
 */
public class UserDao implements IUserDao{
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
