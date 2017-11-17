package com.yangyu.user.api;

import com.yangyu.common.json.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by youz on 2017/11/10.
 */
@RestController
@Api("权限API")
@RequestMapping(value = "/yangyu-permission")
public interface PermissionServer {

    @ApiOperation("查询用户拥有的菜单权限")
    @PostMapping("/authority")
    JsonResult authority(@RequestBody Collection<String> authorities);
}
