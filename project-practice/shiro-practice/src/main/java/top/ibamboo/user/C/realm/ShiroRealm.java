package top.ibamboo.user.C.realm;

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
public class ShiroRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Account account = new Account();
        String password = "123456";

        SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
        principalCollection.add(account.getId(), ShiroRealm.class.getName());
        principalCollection.add(account.getAccountName(), ShiroRealm.class.getName());
        return new SimpleAuthenticationInfo(principalCollection, password);
    }

}
