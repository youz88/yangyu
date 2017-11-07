package com.yangyu.news.user.web;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.util.U;
import com.yangyu.global.model.JwtUser;
import com.yangyu.news.user.model.User;
import com.yangyu.news.user.service.UserService;
import com.yangyu.news.user.util.SpringSecurityUtil;
import com.yangyu.news.user.web.dto.LoginDto;
import com.yangyu.news.user.web.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public JsonResult<UserInfoVo> info() {
        return JsonResult.success("用户详情", UserInfoVo.assemblyData(SpringSecurityUtil.getJwtUser()));
    }

}
