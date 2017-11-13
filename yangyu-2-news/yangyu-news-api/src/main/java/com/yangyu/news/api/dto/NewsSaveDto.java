package com.yangyu.news.api.dto;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("作者")
    private String author;

    @ApiModelProperty("部分内容")
    private String contentPart;

    @ApiModelProperty("发表时间")
    private String createDate;

    @ApiModelProperty("链接地址")
    private String href;
}
