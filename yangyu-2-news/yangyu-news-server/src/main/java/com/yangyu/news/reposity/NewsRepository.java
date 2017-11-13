package com.yangyu.news.reposity;

import com.yangyu.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by youz on 2017/11/10.
 */
@Repository
public interface NewsRepository extends JpaRepository<News,Long>{

}
