package com.yangyu.news.service;

import com.yangyu.news.model.News;

import java.util.List; /**
 * Created by youz on 2017/11/10.
 */
public interface NewsService {

    void save(List<News> list);

    void delete(List<Long> ids);
}
