package com.yangyu.web.controller;

import com.yangyu.api.UserApi;
import com.yangyu.common.json.JsonResult;
import com.yangyu.user.api.dto.RegisterDto;
import com.yangyu.user.api.vo.UserInfoVo;
import com.yangyu.web.constant.Config;
import com.yangyu.web.security.SpringSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserApi userApi;

    @PostMapping("/info")
    public JsonResult<UserInfoVo> info() {
        return JsonResult.success("用户详情", UserInfoVo.assemblyJwtData(SpringSecurityUtil.getJwtUser()));
    }

    @PostMapping("/register")
    public JsonResult register(RegisterDto registerDto){
        return userApi.register(registerDto);
    }


}
