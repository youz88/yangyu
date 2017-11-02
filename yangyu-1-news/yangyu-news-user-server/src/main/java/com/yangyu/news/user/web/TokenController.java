package com.yangyu.news.user.web;

import com.yangyu.api.IConfig;
import com.yangyu.common.json.JsonResult;
import com.yangyu.news.user.model.User;
import com.yangyu.news.user.service.UserService;
import com.yangyu.news.user.web.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/10/27.
 */
@RestController
@RequestMapping("/auth")
public class TokenController {

    @Autowired
    UserService userService;
    @Autowired
    IConfig config;

    @PostMapping("/token")
    public JsonResult login(LoginDto loginDto) {
        User user = userService.login(loginDto.userData());
//        String token = jwtFactory.createToken(user, config.getValue(Const.SECRET_KEY));
        return JsonResult.success("登录成功");
    }

    @PostMapping("/deToken")
    public JsonResult login(String token){
//        return JsonResult.success("自包含信息", jwtFactory.parseToken(token,config.getValue(Const.SECRET_KEY)));
        return JsonResult.success("hello world");
    }

}
