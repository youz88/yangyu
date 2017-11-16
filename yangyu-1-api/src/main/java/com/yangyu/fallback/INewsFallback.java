package com.yangyu.fallback;

import com.yangyu.api.NewsApi;
import com.yangyu.common.json.JsonResult;
import com.yangyu.common.page.Page;
import com.yangyu.common.page.PageInfo;
import com.yangyu.common.util.LogUtil;
import com.yangyu.common.util.U;
import com.yangyu.news.api.dto.NewsSaveDto;
import com.yangyu.news.api.dto.NewsSaveDtoList;
import com.yangyu.news.api.vo.NewsVo;
import feign.hystrix.FallbackFactory;
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
                LogUtil.ROOT_LOG.error("服务器异常,保存失败");
            }

            @Override
            public JsonResult<PageInfo> list(String search, Page page) {
                LogUtil.ROOT_LOG.error("服务器异常,显示列表失败");
                return JsonResult.fail("暂时没有你想要的内容");
            }

        };
    }
}
