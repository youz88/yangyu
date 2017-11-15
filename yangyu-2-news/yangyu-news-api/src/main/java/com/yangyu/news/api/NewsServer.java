package com.yangyu.news.api;

import com.yangyu.common.json.JsonResult;
import com.yangyu.news.api.dto.NewsSaveDto;
import com.yangyu.news.api.vo.NewsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by youz on 2017/11/13.
 */
@Api("资讯API")
@RequestMapping(value = "/news")
public interface NewsServer {

    @ApiOperation("查询资讯信息列表")
    @RequestMapping(value = "/save")
    void save(@RequestBody List<NewsSaveDto> list);

    @ApiOperation("查询资讯信息列表")
    @GetMapping("/list")
    JsonResult<NewsVo> list();
}
