package top.ibamboo.user.C.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by C0907 on 2017/8/28.
 */
@Data
public class LoginParam implements Serializable {
    private static final long serialVersionUID = 5390717092591010475L;
    private String username;
    private String noLogin;
    private String password;
}
