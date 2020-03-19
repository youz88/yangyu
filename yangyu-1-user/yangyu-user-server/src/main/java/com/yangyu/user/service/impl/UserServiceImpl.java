package com.yangyu.user.service.impl;

import com.yangyu.common.Const;
import com.yangyu.common.date.DateUtil;
import com.yangyu.common.util.U;
import com.yangyu.user.model.User;
import com.yangyu.user.repository.UserRepository;
import com.yangyu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User selectById(Long id) {
        Optional<User> user = userRepository.findById(id);
        U.assertException(!user.isPresent(),"该用户不存在");
        return user.get();
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

    @Override
    public void register(User user) {
        user.setCreateDate(DateUtil.now().getTime())
                .setCreateId(Const.SUPER_ID);
        userRepository.save(user);
    }
}
