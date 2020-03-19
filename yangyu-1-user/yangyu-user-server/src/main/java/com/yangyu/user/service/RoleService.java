package com.yangyu.user.service;

import com.yangyu.user.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> selectByUser(Long userId);
}
