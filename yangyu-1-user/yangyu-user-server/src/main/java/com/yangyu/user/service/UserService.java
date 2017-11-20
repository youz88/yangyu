package com.yangyu.user.service;


import com.yangyu.common.json.JsonResult;
import com.yangyu.user.model.User;

/**
 * Created by youz on 2017/10/27.
 */
public interface UserService {

    User selectById(Long id);

    User selectByName(String userName);

    void save(User user);

    void register(User user);
}
