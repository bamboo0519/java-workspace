package top.ibamboo.practice.listbean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by bamboo on 2017/8/21.
 */
@Slf4j
@Component
public class ApplicationContextHandle implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHandle.applicationContext = applicationContext;
    }

    /**
     * 获取对象
     * 这里重写了bean方法，起主要作用
     * @param name
     * @return Object 一个以所给名字注册的bean的实例
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        checkApplicationContext();
        return applicationContext.getBean(name);
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
     *
     * T 为Map类型
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class clazz) {
        checkApplicationContext();
        return (T) applicationContext.getBeansOfType(clazz);
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext未注入");
        }
    }
}
