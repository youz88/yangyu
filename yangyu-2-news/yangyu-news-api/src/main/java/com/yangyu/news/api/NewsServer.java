package com.yangyu.news.api;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.page.Page;
import com.yangyu.common.page.PageInfo;
import com.yangyu.news.api.dto.NewsManageDto;
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
    @PostMapping("/save")
    void save(@RequestBody List<NewsSaveDto> list);

    @ApiOperation("资讯信息列表")
    @PostMapping("/list")
    JsonResult<PageInfo> list(@RequestParam("search") String search, @RequestBody Page page);

    //由于@RequestBody只有有一个，只有把page拆开
    @ApiOperation("后台资讯列表")
    @PostMapping("/manage/list")
    JsonResult<PageInfo> manageList(@RequestBody NewsManageDto newsManageDto, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit);

    @ApiOperation("删除资讯")
    @PostMapping("/manage/del")
    JsonResult manageDel(@RequestBody List<Long> ids);
}
