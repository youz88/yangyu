package com.yangyu.user.service.impl;

import com.yangyu.common.util.U;
import com.yangyu.user.model.User;
import com.yangyu.user.repository.UserRepository;
import com.yangyu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by youz on 2017/10/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User selectById(Long id) {
        User user = userRepository.findOne(id);
        U.assertNil(user,"该用户不存在");
        return user;
    }

    @Cacheable(value = "user", key = "#userName")
    @Override
    public User selectByName(String userName) {
        User user = userRepository.selectByName(userName);
        U.assertNil(user,"该用户不存在");
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
