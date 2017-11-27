package com.yangyu.news.service.impl;

import com.google.common.collect.Lists;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.news.model.News;
import com.yangyu.news.repository.NewsRepository;
import com.yangyu.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void delete(List<Long> ids) {
        List<News> list = Lists.newArrayList();
        ids.forEach(id -> list.add(new News().setId(id)));
        newsRepository.delete(list);
    }
}
