package com.yangyu.news.model;

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

    private String title;

    private String author;

    private String content;

    private Long create_date;
}
