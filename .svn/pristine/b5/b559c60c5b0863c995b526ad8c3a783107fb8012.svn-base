package com.royao.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by libia on 2015/12/31.
 */
public class BeanLoader<T extends Object> {

    private static ApplicationContext ac = null;

    static {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }


    public static <T> T getBean(String name) {
        T t = (T) ac.getBean(name);
        return t;
    }
}
