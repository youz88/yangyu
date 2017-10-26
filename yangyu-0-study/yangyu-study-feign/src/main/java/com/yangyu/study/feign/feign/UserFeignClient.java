package com.yangyu.study.feign.feign;

import com.yangyu.study.feign.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by youz on 2017/10/26.
 */
@FeignClient("yangyu-study-user-service")
@RequestMapping("/user")
public interface UserFeignClient {

    @RequestMapping("/{id}")
    User info(@RequestParam("id") Long id);
}
