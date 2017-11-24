package com.yangyu.api;

import com.yangyu.fallback.INewsFallback;
import com.yangyu.news.api.NewsServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by youz on 2017/11/13.
 */
@FeignClient(name = "yangyu-2-news",fallbackFactory = INewsFallback.class)
@RibbonClient
public interface NewsApi extends NewsServer{

}
