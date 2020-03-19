package com.yangyu.api;

import com.yangyu.fallback.INewsFallback;
import com.yangyu.news.api.NewsServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "yangyu-2-news",fallbackFactory = INewsFallback.class)
@RibbonClient
public interface NewsApi extends NewsServer{

}
