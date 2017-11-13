package com.yangyu.user.api;

import com.yangyu.common.json.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/11/10.
 */
@RestController
@Api("权限API")
@RequestMapping(value = "/permission")
public interface PermissionServer {

    @ApiOperation("查询用户拥有的菜单权限")
    @RequestMapping("/authority")
    JsonResult authority(String[] authorities);
}
