package com.yangyu.study.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yangyu.study.hystrix.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by youz on 2017/10/26.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/{id}")
    public User info(@PathVariable Long id){
        try {
            TimeUnit.MINUTES.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject("http://yangyu-study-user-service/user/"+id,User.class);
    }

    public User fallback(Long id){
        System.out.println("错误ID:"+id);
        return  User.defaultModel();
    }
}
