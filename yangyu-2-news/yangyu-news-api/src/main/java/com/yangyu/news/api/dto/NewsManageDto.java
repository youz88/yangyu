package com.yangyu.news.api.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 后台资讯列表查询
 */
@Getter
@Setter
@NoArgsConstructor
public class NewsManageDto {

    @ApiParam("标题")
    private String title;

    @ApiParam("作者")
    private String author;

    @ApiParam("发表时间")
    private String publish_date;

}
