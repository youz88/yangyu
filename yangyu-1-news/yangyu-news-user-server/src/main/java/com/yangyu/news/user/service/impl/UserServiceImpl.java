package com.yangyu.news.user.service.impl;

import com.yangyu.news.user.repository.UserRepository;
import com.yangyu.news.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by youz on 2017/10/27.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

}
