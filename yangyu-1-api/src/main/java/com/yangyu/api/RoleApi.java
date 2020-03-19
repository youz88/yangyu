package com.yangyu.api;

import com.yangyu.fallback.IRoleFallback;
import com.yangyu.user.api.RoleServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "yangyu-1-user",fallbackFactory = IRoleFallback.class)
@RibbonClient
public interface RoleApi extends RoleServer{
}
