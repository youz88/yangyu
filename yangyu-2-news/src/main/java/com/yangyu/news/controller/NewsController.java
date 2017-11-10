package com.yangyu.news.controller;

import com.yangyu.common.json.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/11/10.
 */

@RestController
@RequestMapping("/news")
public class NewsController {

    @GetMapping("/list")
    public JsonResult list(){

        return JsonResult.success("咨询列表");
    }
}
