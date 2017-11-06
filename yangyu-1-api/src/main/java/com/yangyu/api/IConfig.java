package com.yangyu.api;

import com.yangyu.api.fallback.IConfigFallback;
import com.yangyu.global.enums.ConfigType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by youz on 2017/11/2.
 */
@FeignClient(value = "yangyu-0-config",fallback = IConfigFallback.class)
public interface IConfig {

    @PostMapping("/sysConfig/value")
    String getValue(@RequestParam("configType") ConfigType configType);


}
