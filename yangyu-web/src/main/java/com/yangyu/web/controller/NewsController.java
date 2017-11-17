package com.yangyu.web.controller;

import com.yangyu.api.NewsApi;
import com.yangyu.common.json.JsonResult;
import com.yangyu.common.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/11/17.
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsApi newsApi;

    @GetMapping("/list")
    public JsonResult list(String search, Page page){
        return newsApi.list(search,page);
    }
}
