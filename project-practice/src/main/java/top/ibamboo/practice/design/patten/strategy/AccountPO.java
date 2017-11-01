package top.ibamboo.practice.design.patten.strategy;

import lombok.Data;

import java.util.Date;

/**
 * Created by bamboo on 2017/8/17.
 */
@Data
public class AccountPO {
    int id;
    String account;
    String name;
    String password;
    String mobile;

    /**
     * 状态   0为停用，-2为删除，1为启用，11为guestBook被拉黑
     */
    Integer status;
    /**
     * 创建时间
     */
    Date createdAt;

    /**
     * 更新时间
     */
    Date updatedAt;
}
