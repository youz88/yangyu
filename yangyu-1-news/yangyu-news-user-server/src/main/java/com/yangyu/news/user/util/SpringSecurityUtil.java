package com.yangyu.news.user.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Created by youz on 2017/11/3.
 */
public class SpringSecurityUtil {

    public static String getUserName(){
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
