package com.yangyu.news.user.web;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.util.U;
import com.yangyu.global.model.JwtUser;
import com.yangyu.news.user.model.User;
import com.yangyu.news.user.service.UserService;
import com.yangyu.news.user.util.SpringSecurityUtil;
import com.yangyu.news.user.web.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by youz on 2017/10/27.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/info")
    public JsonResult info(){
        return JsonResult.success("用户详情",userService.selectByName(SpringSecurityUtil.getUserName()));
}

    @PostMapping("/signup")
    public void signUp(LoginDto loginDto) {
        User signUser = loginDto.userData();
        U.assertException(
                U.isNotBlank(userService.selectByName(signUser.getUserName())), "该用户已存在");
        userService.save(signUser);
    }
}
