package com.yangyu.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by youz on 2017/11/2.
 */
@FeignClient("yangyu-0-config")
@RequestMapping("/sysConfig")
public interface IConfig {

    @PostMapping("/value")
    String getValue(@RequestParam("key") String key);
}
