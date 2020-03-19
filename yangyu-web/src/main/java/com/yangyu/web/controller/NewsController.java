package com.yangyu.web.controller;

import com.yangyu.api.NewsApi;
import com.yangyu.common.json.JsonResult;
import com.yangyu.common.page.Page;
import com.yangyu.news.api.dto.NewsManageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsApi newsApi;

    @GetMapping("/list")
    public JsonResult list(String search, Page page){
        return newsApi.list(search,page);
    }

    @GetMapping("/manage/list")
    public JsonResult manageList(NewsManageDto newsManageDto, Page page){
        return newsApi.manageList(newsManageDto,page.getPage(),page.getLimit());
    }
}
