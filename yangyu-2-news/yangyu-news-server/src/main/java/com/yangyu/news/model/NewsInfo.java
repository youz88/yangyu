//package com.yangyu.news.model;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//
///**
// * Created by youz on 2017/11/14.
// * 仅通过ES查询作列表展示，不存入数据库
// */
//@Document(indexName = "yangyu-2-news",type = "news", shards = 1,replicas = 0, refreshInterval = "-1")
//@Getter
//@Setter
//@NoArgsConstructor
//public class NewsInfo {
//
//    private Long id;
//
//    /**
//     * 标题
//     */
//    @Field
//    private String title;
//
//    /**
//     * 作者
//     */
//    @Field
//    private String author;
//
//    /**
//     * 内容
//     */
//    @Field
//    private String contentPart;
//
//    /**
//     * 发表时间
//     */
//    @Field
//    private String publishDate;
//
//    /**
//     * 链接地址
//     */
//    @Field
//    private String href;
//
//    @Field
//    private Long createId;
//
//    @Field
//    private Long createDate;
//}
