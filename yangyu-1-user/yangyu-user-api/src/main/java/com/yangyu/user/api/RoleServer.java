package com.yangyu.user.api;

import com.yangyu.common.json.JsonResult;
import com.yangyu.user.api.vo.RoleVo;
import com.yangyu.user.api.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("角色服务API")
@RequestMapping(value = "/yangyu-role")
public interface RoleServer {

    @ApiOperation("获取用户详情")
    @PostMapping(value = "/info/{id}")
    List<RoleVo> selectByUser(@PathVariable("id") Long id);
}
