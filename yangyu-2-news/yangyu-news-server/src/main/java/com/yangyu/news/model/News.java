package com.yangyu.news.model;

import com.yangyu.common.Const;
import com.yangyu.common.annotation.Document;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    @Column(length = 260)
    private String contentPart;

    /**
     * 发表时间
     */
    @Column(length = 25)
    private String publishDate;

    /**
     * 链接地址
     */
    @Column(length = 150)
    private String href;

    /**
     * 头像
     */
    @Column(length = 150)
    private String avatar;

    @Column
    private Long createId = Const.SUPER_ID;

    @Column
    private Long createDate = new Date().getTime();

    @Column
    private Long modifyId;

    @Column
    private Long modifyDate;

}
