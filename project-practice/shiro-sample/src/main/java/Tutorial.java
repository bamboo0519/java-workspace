/**
 * Created by bamboo on 2017/9/5.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial {

    private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);

    public static void main(String[] args) {

        log.info("My First Apache Shiro Application");

        //1.
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2.
        SecurityManager securityManager = factory.getInstance();

        //3.
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute( "someKey", "aValue" );
        log.info("flag------------------1");
        if ( !currentUser.isAuthenticated() ) {
            //collect user principals and credentials in a gui specific manner
            //such as username/password html form, X509 certificate, OpenID, etc.
            //We'll use the username/password example here since it is the most common.
            log.info("flag------------------2");
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");

            //this is all you have to do to support 'remember me' (no config - built in!):
            token.setRememberMe(true);

            currentUser.login(token);

            try {
                currentUser.login( token );
                //if no exception, that's it, we're done!
            } catch ( UnknownAccountException uae ) {
                //username wasn't in the system, show them an error message?
            } catch ( IncorrectCredentialsException ice ) {
                //password didn't match, try again?
            } catch ( LockedAccountException lae ) {
                //account for that username is locked - can't login.  Show them a message?
            } catch ( AuthenticationException ae ) {
            //unexpected condition - error?
            }
        }

        //print their identifying principal (in this case, a username):
        log.info( "User [" + currentUser.getPrincipal() + "] logged in successfully." );

        if ( currentUser.hasRole( "schwartz" ) ) {
            log.info("May the Schwartz be with you!" );
        } else {
            log.info( "Hello, mere mortal." );
        }

        if ( currentUser.isPermitted( "lightsaber:weild" ) ) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        if ( currentUser.isPermitted( "winnebago:drive:eagle5" ) ) {
            log.info("You are permitted to 'drive' the 'winnebago' with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        currentUser.logout();


        System.exit(0);
    }
}