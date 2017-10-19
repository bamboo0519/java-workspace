package top.ibamboo.user.C.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by C0907 on 2017/8/28.
 */
@RestController
@Slf4j
@RequestMapping("")
public class LoginController {

//    @RequestMapping(value = "/userlogin", method = RequestMethod.POST/*, produces = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
//    @ResponseBody
//    public String login(@RequestBody LoginParam loginParam, HttpServletRequest request, HttpServletResponse response) throws Exception {
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST/*, produces = MediaType.APPLICATION_JSON_UTF8_VALUE*/)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info("login[]");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        log.info("login[]{}--{}", userName, password);

        /*就是代表当前的用户。*/
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);


        log.info("login[]session:{}, {}",subject.getSession(), subject.isAuthenticated());

        try {
            subject.login(token);
        } catch ( UnknownAccountException uae ) {
            //username wasn't in the system, show them an error message?
            uae.printStackTrace();
        } catch ( IncorrectCredentialsException ice ) {
            //password didn't match, try again?
            ice.printStackTrace();
        } catch ( LockedAccountException lae ) {
            //account for that username is locked - can't login.  Show them a message?
        } catch ( AuthenticationException ae ) {
            //unexpected condition - error?
            ae.printStackTrace();
        }


        log.info("login[]session1:{}, {}",subject.getSession(), subject.isAuthenticated());

        return null;
    }



}
