//package com.yangyu.news.service.impl;
//
//import com.yangyu.news.model.NewsInfo;
//import com.yangyu.news.reposity.ESNewsRepository;
//import com.yangyu.news.service.ESNewsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.querydsl.QPageRequest;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * Created by youz on 2017/11/14.
// */
//@Service
//public class ESNewsServiceImpl implements ESNewsService{
//
//    @Autowired
//    ESNewsRepository esNewsRepository;
//
//    @Override
//    public Page<NewsInfo> findByPage(Integer page, Integer size) {
//        return esNewsRepository.findAll(new QPageRequest(page,size));
//    }
//}
