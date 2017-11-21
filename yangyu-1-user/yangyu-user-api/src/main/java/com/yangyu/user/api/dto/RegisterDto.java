package com.yangyu.user.api.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpEntity;

/**
 * Created by youz on 2017/11/20.
 */
@Getter
@Setter
@NoArgsConstructor
public class RegisterDto {

    @ApiParam("邮箱")
    private String email;

    @ApiParam("密码")
    private String password;

    @ApiParam("确认密码")
    private String confirmPwd;

    @ApiParam("电话")
    private String phone;

    @ApiParam("验证码")
    private String captcha;

}
