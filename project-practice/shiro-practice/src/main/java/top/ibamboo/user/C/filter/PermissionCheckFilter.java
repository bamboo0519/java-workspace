package top.ibamboo.user.C.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by bamboo on 2017/9/13.
 */
@Slf4j
@Component
public class PermissionCheckFilter  extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        log.info("isAccessAllowed[]PermissionCheckFilter");

        return true;
    }
}
