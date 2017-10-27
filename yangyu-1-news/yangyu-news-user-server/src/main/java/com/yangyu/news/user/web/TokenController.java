package com.yangyu.news.user.web;

import com.yangyu.news.user.web.dto.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/10/27.
 */
@RestController
@RequestMapping("/auth")
public class TokenController {

    @RequestMapping("/login")
    public ResponseEntity login(LoginDto loginDto){

        return ResponseEntity.ok("登录成功");
    }
}
