package com.yangyu.user.service.impl;

import com.google.common.collect.Lists;
import com.yangyu.common.Const;
import com.yangyu.common.util.A;
import com.yangyu.common.util.U;
import com.yangyu.user.model.Permission;
import com.yangyu.user.repository.PermissionRepository;
import com.yangyu.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    PermissionRepository permissionRepository;

    @Cacheable(value = "permission", key = "#authorities")
    @Override
    public List<Permission> selectByRole(Collection<String> authorities) {
        return permissionRepository.selectByRole(authorities);
    }

}
