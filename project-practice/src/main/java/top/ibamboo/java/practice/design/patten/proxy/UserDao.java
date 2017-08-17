package top.ibamboo.java.practice.design.patten.proxy;

/**
 * Created by C0907 on 2017/8/15.
 */
public class UserDao implements IUserDao{
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
