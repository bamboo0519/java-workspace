package top.ibamboo.account.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by bamboo on 2017/8/28.
 */
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    Long id;
    String accountId;
    String accountName;
    String password;
    String mobile;
    String email;
    Date createdAt;
    Date updatedAt;
}
