package com.yangyu.api;

import com.yangyu.fallback.IRoleFallback;
import com.yangyu.user.api.RoleServer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by youz on 2017/11/10.
 */
@FeignClient(name = "yangyu-1-user",fallbackFactory = IRoleFallback.class)
@RibbonClient
public interface RoleApi extends RoleServer{
}
