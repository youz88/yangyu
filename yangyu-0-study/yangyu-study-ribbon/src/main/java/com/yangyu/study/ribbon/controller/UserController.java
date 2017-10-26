package com.yangyu.study.ribbon.controller;

import com.yangyu.study.ribbon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by youz on 2017/10/26.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public User info(@PathVariable Long id){
        return restTemplate.getForObject("http://yangyu-study-user-service/user/" + id, User.class);
    }
}
