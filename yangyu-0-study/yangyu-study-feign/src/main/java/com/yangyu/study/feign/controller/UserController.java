package com.yangyu.study.feign.controller;

import com.google.common.collect.Lists;
import com.yangyu.study.feign.feign.UserFeignClient;
import com.yangyu.study.feign.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/10/26.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public User info(@PathVariable Long id){
        return userFeignClient.info(id);
    }

    @GetMapping("/list")
    public User info(){
        User user = new User();
        user.setId(1L);
        return userFeignClient.list(Lists.newArrayList(user));
    }
}
