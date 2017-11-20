package com.yangyu.api;

import com.yangyu.common.json.JsonResult;
import com.yangyu.fallback.IUserFallback;
import com.yangyu.user.api.UserServer;
import com.yangyu.user.api.dto.RegisterDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by youz on 2017/11/10.
 */
@FeignClient(name = "yangyu-1-user",fallbackFactory = IUserFallback.class)
@RibbonClient
public interface UserApi extends UserServer{

}


