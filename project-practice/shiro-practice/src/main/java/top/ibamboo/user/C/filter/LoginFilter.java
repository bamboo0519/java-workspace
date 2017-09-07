package top.ibamboo.user.C.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by C0907 on 2017/8/28.
 */
@Component
@Slf4j
public class LoginFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        log.info("isAccessAllowed[]");

        return true;
    }

}
