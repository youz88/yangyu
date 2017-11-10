package com.yangyu.api;

import com.yangyu.fallback.IConfigFallback;
import com.yangyu.global.enums.ConfigType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by youz on 2017/11/2.
 */
@FeignClient(name = "yangyu-0-config",fallbackFactory = IConfigFallback.class)
@RibbonClient
public interface ConfigApi {

    @PostMapping("/sysConfig/value")
    String getValue(@RequestParam("configType") ConfigType configType);

}
