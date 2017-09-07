package top.ibamboo.user.C.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import top.ibamboo.user.C.model.LoginParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by C0907 on 2017/8/28.
 */
@RestController
@Slf4j
@RequestMapping("")
public class LoginController {

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String login(@RequestBody LoginParam loginParam, HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("login[]");

        Subject subject = SecurityUtils.getSubject();

        log.info("login[]session:{}",subject.getSession());

        return null;
    }



}
