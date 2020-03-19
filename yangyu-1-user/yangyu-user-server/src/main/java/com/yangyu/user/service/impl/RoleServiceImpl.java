package com.yangyu.user.service.impl;

import com.yangyu.user.model.Role;
import com.yangyu.user.repository.RoleRepository;
import com.yangyu.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Cacheable(value = "role", key = "#userId")
    @Override
    public List<Role> selectByUser(Long userId) {
        return roleRepository.selectByUser(userId);
    }
}
