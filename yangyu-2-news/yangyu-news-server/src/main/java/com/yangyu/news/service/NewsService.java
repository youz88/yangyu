package com.yangyu.news.service;
import com.yangyu.news.model.News;
import java.util.List;

public interface NewsService {

    void save(List<News> list);

    void delete(List<Long> ids);
}
