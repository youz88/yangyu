package com.yangyu.news.user.service;

import com.yangyu.news.user.model.User; /**
 * Created by youz on 2017/10/27.
 */
public interface UserService {

    User login(User user);

    User selectById(Long id);

    User selectByName(String userName);

    void save(User user);
}
