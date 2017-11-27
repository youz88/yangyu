package com.yangyu.fallback;

import com.yangyu.api.NewsApi;
import com.yangyu.common.json.JsonResult;
import com.yangyu.common.page.Page;
import com.yangyu.common.page.PageInfo;
import com.yangyu.common.util.LogUtil;
import com.yangyu.news.api.dto.NewsManageDto;
import com.yangyu.news.api.dto.NewsSaveDto;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by youz on 2017/11/13.
 */
@Component
public class INewsFallback implements FallbackFactory<NewsApi> {

    @Override
    public NewsApi create(Throwable throwable) {
        return new NewsApi() {

            @Override
            public void save(List<NewsSaveDto> list) {
                LogUtil.ROOT_LOG.error("服务器异常,保存失败",throwable);
            }

            @Override
            public JsonResult<PageInfo> list(String search, Page page) {
                LogUtil.ROOT_LOG.error("服务器异常,显示列表失败",throwable);
                return JsonResult.fail("暂时没有你想要的内容");
            }

            @Override
            public JsonResult<PageInfo> manageList(NewsManageDto newsManageDto, Integer page, Integer limit) {
                LogUtil.ROOT_LOG.error("服务器异常,显示列表失败",throwable);
                return JsonResult.fail("暂时没有你想要的内容");
            }

            @Override
            public JsonResult manageDel(List<Long> ids) {
                LogUtil.ROOT_LOG.error("服务器异常,删除资讯失败",throwable);
                return JsonResult.fail("删除资讯失败,请稍后再试");
            }

        };
    }
}
