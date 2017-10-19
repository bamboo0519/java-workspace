package top.ibamboo.user.C.autoconfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import top.ibamboo.user.C.beans.JedisCacheManager;
import top.ibamboo.user.C.filter.LoginFilter;
import top.ibamboo.user.C.filter.PermissionCheckFilter;
import top.ibamboo.user.C.realm.ShiroRealm;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by C0907 on 2017/8/28.
 */
@Configuration
@Slf4j
public class ShiroAutoConfiguration {
    @Bean
    @Autowired(required = false)
    public CacheManager cacheManager(UaaProperties properties, RedisTemplate redisTemplate){
        return new JedisCacheManager(redisTemplate);
    }

//    @Bean
//    @Autowired
//    @Qualifier("rememberMeCookie")
//    public CookieRememberMeManager rememberMeManager(SimpleCookie rememberMeCookie) throws BeansException {
//        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
//        rememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
//        rememberMeManager.setCookie(rememberMeCookie);
//
//        return rememberMeManager;
//    }
//    @Bean
//    @Autowired
//    public SessionManager sessionManager(QuartzSessionValidationScheduler scheduler,
//                                         SessionDAO sessionDAO,
//                                         @Qualifier("sessionIdCookie") Cookie sessionIdCookie){
//        UaaWebSessionManager sessionManager = new UaaWebSessionManager();
//        sessionManager.setGlobalSessionTimeout(1800000);
//        sessionManager.setDeleteInvalidSessions(true);
//        sessionManager.setSessionValidationSchedulerEnabled(false);
//        /*sessionManager.setSessionValidationScheduler(scheduler);*/
//        scheduler.setSessionManager(sessionManager);
//        sessionManager.setSessionDAO(sessionDAO);
//        sessionManager.setSessionIdCookieEnabled(true);
//        sessionManager.setSessionIdCookie(sessionIdCookie);
//
//        return sessionManager;
//    }
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    @Bean
    @Autowired (required = false)
    public SecurityManager securityManager(List<Realm> realms
                                           /*SessionManager sessionManager,
                                           CacheManager cacheManager,
                                           RememberMeManager rememberMeManager*/){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealms(realms);
//        securityManager.setSessionManager(sessionManager);
//        securityManager.setCacheManager(cacheManager);

//        securityManager.setRememberMeManager(rememberMeManager);
        SecurityUtils.setSecurityManager(securityManager);

        return securityManager;
    }

    @Bean
    @Autowired(required = false)
    public Filter shiroFilter(SecurityManager securityManager,
                              LoginFilter loginFilter,
                              PermissionCheckFilter permissionCheckFilter) throws Exception {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        filterFactoryBean.setLoginUrl(null);
        filterFactoryBean.setSuccessUrl("/");
        Map<String, Filter> filters = new HashMap<>();
        filters.put("loginFilter", loginFilter);
        filters.put("permissionCheckFilter", permissionCheckFilter);
        filterFactoryBean.setFilters(filters);

        Map<String, String> map = new HashMap<>();
        map.put("/login", "loginFilter");
        map.put("/public/**", "anon");
        map.put("/protect/**", "permissionCheckFilter");
        filterFactoryBean.setFilterChainDefinitionMap(map);

        return (AbstractShiroFilter)filterFactoryBean.getObject();
    }





}
