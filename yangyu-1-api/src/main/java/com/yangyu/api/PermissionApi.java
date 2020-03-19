package com.yangyu.api;

import com.yangyu.fallback.IPermissionFallback;
import com.yangyu.user.api.PermissionServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "yangyu-1-user",fallbackFactory = IPermissionFallback.class)
@RibbonClient
public interface PermissionApi extends PermissionServer{
}
