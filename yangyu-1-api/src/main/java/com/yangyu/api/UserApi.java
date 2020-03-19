package com.yangyu.api;

import com.yangyu.fallback.IUserFallback;
import com.yangyu.user.api.UserServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "yangyu-1-user",fallbackFactory = IUserFallback.class)
@RibbonClient
public interface UserApi extends UserServer{

}


