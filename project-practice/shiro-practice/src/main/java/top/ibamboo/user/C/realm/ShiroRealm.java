package top.ibamboo.user.C.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import top.ibamboo.account.model.Account;

/**
 * Created by C0907 on 2017/8/29.
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Account account = new Account();
        // TODO 校验 账号密码等信息，不匹配则抛出异常
        account.setId(1000L);
        account.setAccountId("1000");
        account.setAccountName("bamboo");
        String password = "123456";
        log.info("doGetAuthenticationInfo[] token:{}",token);

        SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
        principalCollection.add(account.getAccountId(), ShiroRealm.class.getName());
        principalCollection.add(account.getAccountName(), ShiroRealm.class.getName());
        log.info("doGetAuthenticationInfo[] token:{}, getCredentials:{}",token,token.getCredentials());
        return new SimpleAuthenticationInfo(principalCollection, token.getCredentials());
    }

}
