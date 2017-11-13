package com.yangyu.news.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Created by youz on 2017/11/9.
 * 新闻资讯
 */
@Entity
@Table(name = "yangyu_news")
@Getter
@Setter
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    @Column(length = 50)
    private String title;

    /**
     * 作者
     */
    @Column(length = 20)
    private String author;

    /**
     * 内容
     */
    @Column(length = 200)
    private String contentPart;

    @Lob
    @Column(columnDefinition = "text")
    private String content;

    /**
     * 发表时间
     */
    @Column(length = 25)
    private String publishDate;

    /**
     * 链接地址
     */
    @Column(length = 100)
    private String href;

    @Column
    private Long createId;

    @Column
    private Long createDate;

    @Column
    private Long modifyId;

    @Column
    private Long modifyDate;

}
