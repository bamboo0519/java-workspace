package top.ibamboo.practice.h2.classproperty;

import java.io.Serializable;

/**
 * Created by bamboo on 2017/9/15
 *
 * 本来想建 一个class属性的字段；
 *
 * 实际在测试表关联操作
 */
public class AccountExtPo implements Serializable{
    private static final long serialVersionUID = 1L;
    String accountId;

    String height;
    String weight;
}
