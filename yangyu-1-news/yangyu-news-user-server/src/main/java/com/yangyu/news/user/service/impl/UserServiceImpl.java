package com.yangyu.news.user.service.impl;

import com.yangyu.global.model.JwtUser;
import com.yangyu.news.user.model.User;
import com.yangyu.news.user.repository.UserRepository;
import com.yangyu.news.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by youz on 2017/10/27.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User login(User user) {
        User login = userRepository.login(user.getUserName(), user.getPassword());
        Assert.notNull(login,"用户名或密码错误，请重新输入");
        return login;
    }
}
