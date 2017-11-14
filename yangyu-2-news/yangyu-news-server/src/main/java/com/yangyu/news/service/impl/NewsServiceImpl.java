package com.yangyu.news.service.impl;

import com.google.common.collect.Lists;
import com.yangyu.news.model.News;
import com.yangyu.news.reposity.NewsRepository;
import com.yangyu.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by youz on 2017/11/10.
 */
@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void save(List<News> list) {
        newsRepository.save(list);
    }
}