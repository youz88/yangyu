package com.yangyu.news.api.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by youz on 2017/11/13.
 */
@Getter
@Setter
@NoArgsConstructor
public class NewsSaveDto {

    @ApiParam("标题")
    private String title;

    @ApiParam("作者")
    private String author;

    @ApiParam("部分内容")
    private String contentPart;

    @ApiParam("发表时间")
    private String publishDate;

    @ApiParam("链接地址")
    private String href;

    @ApiParam("头像")
    private String avatar;

}
