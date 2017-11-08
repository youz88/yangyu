package com.yangyu.user.web;

import com.yangyu.common.json.JsonResult;
import com.yangyu.user.service.UserService;
import com.yangyu.user.util.SpringSecurityUtil;
import com.yangyu.user.web.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
