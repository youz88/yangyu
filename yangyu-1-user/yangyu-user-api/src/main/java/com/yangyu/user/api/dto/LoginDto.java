package com.yangyu.user.api.dto;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by youz on 2017/10/27.
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginDto {

    @ApiParam("电话")
    private String phone;

    @ApiParam("邮箱")
    private String email;

    @ApiParam(value = "密码",required = true)
    private String password;

    @ApiParam(hidden = true)
    private String username;

}
