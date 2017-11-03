package com.yangyu.news.user.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Created by youz on 2017/11/3.
 */
public class SpringSecurityUtil {

    public static User getUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getUserName(){
        return getUser().getUsername();
    }
}
