package com.yangyu.web.controller;

import com.yangyu.api.PermissionApi;
import com.yangyu.common.json.JsonResult;
import com.yangyu.web.security.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/11/17.
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionApi permissionApi;

    @PostMapping("/authority")
    public JsonResult menu(){
        return permissionApi.authority(SpringSecurityUtil.getAuthorities());
    }
}
