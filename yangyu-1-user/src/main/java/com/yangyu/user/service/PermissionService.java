package com.yangyu.user.service;

import com.yangyu.user.model.Permission;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * Created by youz on 2017/11/9.
 */
public interface PermissionService {

    List<Permission> selectByRole(Collection roles);

}
