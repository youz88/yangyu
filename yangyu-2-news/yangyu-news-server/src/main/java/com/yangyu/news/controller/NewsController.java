package com.yangyu.news.controller;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.page.Page;
import com.yangyu.common.page.PageInfo;
import com.yangyu.news.api.dto.NewsListQueryDto;
import com.yangyu.news.api.vo.NewsVo;
import com.yangyu.global.service.ElasticSearchService;
import com.yangyu.news.api.NewsServer;
import com.yangyu.news.api.dto.NewsSaveDto;
import com.yangyu.news.model.News;
import com.yangyu.news.service.NewsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by youz on 2017/11/10.
 */

@RestController
@Api(value = "NewsApi", description = "资讯API", tags = {"资讯服务"})
public class NewsController implements NewsServer{

    @Autowired
    NewsService newsService;

    @Autowired
    ElasticSearchService elasticSearchService;

    @Override
    public void save(@RequestBody List<NewsSaveDto> list) {
        newsService.save(JsonUtil.convertList(list,News.class));
    }

    @Override
    public JsonResult<PageInfo> list(String search,@RequestBody Page page) {
        PageInfo listBySearch = elasticSearchService.getPageInfoBySearch(search, page, NewsVo.class, true, "content_part", "title");
        return JsonResult.success("资讯列表", listBySearch);
    }

    @Override
    public JsonResult<PageInfo> manageList(@RequestBody NewsListQueryDto newsListQueryDto,@RequestBody Page page) {

        return null;
    }

    @Override
    public JsonResult manageDel(@RequestBody List<Long> id) {
        newsService.delete(id);
        return JsonResult.success("删除成功");
    }

}
