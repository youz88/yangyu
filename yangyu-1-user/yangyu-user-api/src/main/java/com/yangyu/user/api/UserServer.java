package com.yangyu.user.api;

import com.yangyu.common.json.JsonResult;
import com.yangyu.user.api.dto.RegisterDto;
import com.yangyu.user.api.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("用户服务API")
@RequestMapping(value = "/yangyu-user")
public interface UserServer {

    @ApiOperation("获取用户详情")
    @PostMapping("/info/{id}")
    JsonResult<UserInfoVo> info(@PathVariable("id") Long id);

    @ApiOperation("根据用户名查找用户")
    @PostMapping("/selectByName")
    UserInfoVo selectByName(@RequestParam("userName")String userName);

    @ApiOperation("用户注册")
    @PostMapping("/register")
    JsonResult register(@RequestBody RegisterDto registerDto);
}
