package top.ibamboo.account.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by C0907 on 2017/8/28.
 */
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String accountId;
    String accountName;
    String password;
    String mobile;
    String email;
    String createdAt;
    String updatedAt;
}
