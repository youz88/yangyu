package com.yangyu.user.api;

import com.yangyu.common.json.JsonResult;
import com.yangyu.user.api.vo.RoleVo;
import com.yangyu.user.api.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by youz on 2017/11/10.
 */
@RestController
@Api("角色服务API")
@RequestMapping(value = "/role")
public interface RoleServer {

    @ApiOperation("获取用户详情")
    @PostMapping("/info/{id}")
    List<RoleVo> selectByUser(@PathVariable("id") Long id);
}
