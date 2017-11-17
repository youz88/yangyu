package com.yangyu.news.api;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.page.Page;
import com.yangyu.common.page.PageInfo;
import com.yangyu.news.api.dto.NewsSaveDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by youz on 2017/11/13.
 */
@Api("资讯API")
@RequestMapping(value = "/yangyu-news")
public interface NewsServer {

    @ApiOperation("保存资讯信息")
    @RequestMapping(value = "/save")
    void save(@RequestBody List<NewsSaveDto> list);

    @ApiOperation("资讯信息列表")
    @PostMapping("/list")
    JsonResult<PageInfo> list(@RequestParam("search") String search, @RequestBody Page page);
}
