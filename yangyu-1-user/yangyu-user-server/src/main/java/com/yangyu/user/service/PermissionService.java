package com.yangyu.user.service;

import com.yangyu.user.model.Permission;

import java.util.Collection;
import java.util.List;

public interface PermissionService {

    List<Permission> selectByRole(Collection<String> authorities);

}
