package com.yangyu.user.controller;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.util.U;
import com.yangyu.user.api.PermissionServer;
import com.yangyu.user.api.vo.PermissionVo;
import com.yangyu.user.service.PermissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by youz on 2017/11/9.
 */
@RestController
@Api(value = "PermissionApi", description = "权限API", tags = {"权限服务"})
public class PermissionController implements PermissionServer{

    @Autowired
    PermissionService permissionService;

    @Override
    public JsonResult authority(@RequestBody List<String> authorities) {
        U.assertNil(authorities,"权限不能为空");
        return JsonResult.success("菜单", PermissionVo.assemblyData(permissionService.selectByRole(authorities)));
    }
}
