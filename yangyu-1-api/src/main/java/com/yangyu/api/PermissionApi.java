package com.yangyu.api;

import com.yangyu.fallback.IPermissionFallback;
import com.yangyu.user.api.PermissionServer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by youz on 2017/11/17.
 */
@FeignClient(name = "yangyu-1-user",fallbackFactory = IPermissionFallback.class)
@RibbonClient
public interface PermissionApi extends PermissionServer{
}
