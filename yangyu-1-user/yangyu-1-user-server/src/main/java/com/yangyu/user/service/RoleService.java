package com.yangyu.user.service;

import com.yangyu.user.model.Role;

import java.util.List;

/**
 * Created by youz on 2017/11/8.
 */
public interface RoleService {

    List<Role> selectByUser(Long userId);
}
