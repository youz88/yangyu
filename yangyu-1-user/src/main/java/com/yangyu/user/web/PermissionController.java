package com.yangyu.user.web;

import com.yangyu.common.json.JsonResult;
import com.yangyu.user.service.PermissionService;
import com.yangyu.user.util.SpringSecurityUtil;
import com.yangyu.user.web.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Created by youz on 2017/11/9.
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/all")
    public JsonResult all(){
        Collection authorities = SpringSecurityUtil.getAuthorities();
        return JsonResult.success("菜单", PermissionVo.assemblyData(permissionService.selectByRole(authorities)));
    }

}
