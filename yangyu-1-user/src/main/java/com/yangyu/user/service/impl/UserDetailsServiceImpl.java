package com.yangyu.user.service.impl;

import com.yangyu.common.util.U;
import com.yangyu.user.model.User;
import com.yangyu.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "user", key = "#username")
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.selectByName(username);
        U.assertNil(user,"该用户不存在");
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), emptyList());
    }

}
