package com.yangyu.study.user.controller;

import com.yangyu.study.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/10/25.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public User info(User user){
        return null;
    }

    @GetMapping("hello")
    public String hello(){
        return "hello world";
    }
}
