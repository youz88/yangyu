package com.yangyu.news.user.web;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.JwtUtil;
import com.yangyu.global.model.JwtUser;
import com.yangyu.news.user.model.User;
import com.yangyu.news.user.service.UserService;
import com.yangyu.news.user.web.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/token")
    public JsonResult login(LoginDto loginDto) {
        User user = userService.login(loginDto.userData());
        String token = JwtUtil.encode(JsonUtil.convert(user,JwtUser.class).toMap(), "123");
        return JsonResult.success(token);
    }

    @PostMapping("/deToken")
    public JsonResult login(String token){
        return JsonResult.success("自包含信息",JwtUtil.decode(token,"123"));
    }

}
