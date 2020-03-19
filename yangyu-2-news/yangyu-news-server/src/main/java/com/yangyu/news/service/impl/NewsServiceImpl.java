package com.yangyu.news.service.impl;

import com.google.common.collect.Lists;
import com.yangyu.news.model.News;
import com.yangyu.news.repository.NewsRepository;
import com.yangyu.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void save(List<News> list) {
        newsRepository.saveAll(list);
    }

    @Override
    public void delete(List<Long> ids) {
        List<News> list = Lists.newArrayList();
        ids.forEach(id -> list.add(new News().setId(id)));
        newsRepository.deleteAll(list);
    }
}
