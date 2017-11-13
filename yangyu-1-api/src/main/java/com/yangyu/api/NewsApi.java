package com.yangyu.api;

import com.yangyu.fallback.INewsFallback;
import com.yangyu.news.api.NewsServer;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by youz on 2017/11/13.
 */
@FeignClient(name = "yangyu-2-news",fallbackFactory = INewsFallback.class)
@RibbonClient
public interface NewsApi extends NewsServer{
}
