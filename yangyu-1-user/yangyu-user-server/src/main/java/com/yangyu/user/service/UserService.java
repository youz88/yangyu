package com.yangyu.user.service;


import com.yangyu.common.json.JsonResult;
import com.yangyu.user.model.User;

public interface UserService {

    User selectById(Long id);

    User selectByName(String userName);

    void save(User user);

    void register(User user);
}
