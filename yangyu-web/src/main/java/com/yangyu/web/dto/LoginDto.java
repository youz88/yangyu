package com.yangyu.web.dto;

import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.U;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.DigestUtils;

import java.util.Base64;

@Getter
@Setter
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
