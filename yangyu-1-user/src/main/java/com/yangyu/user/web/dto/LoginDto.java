package com.yangyu.user.web.dto;

import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.U;
import com.yangyu.user.enums.AccountType;
import com.yangyu.user.model.User;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.DigestUtils;

import java.util.Base64;

/**
 * Created by youz on 2017/10/27.
 */
@Getter
@Setter
public class LoginDto {

    @ApiParam("电话")
    private String phone;

    @ApiParam("邮箱")
    private String email;

    @ApiParam(value = "密码",required = true)
    private String password;

    @ApiParam("账号类型")
    private AccountType accountType;

    @ApiParam(hidden = true)
    private String username;

    public User userData(){
        U.assertNil(accountType,"账户类型不能为空");
        U.assertNil(password,"密码不能为空");
        if(accountType.isPhone()){
            this.username = phone;
        }else if(accountType.isEmail()){
            this.username = email;
        }
        this.password = DigestUtils.md5DigestAsHex(Base64.getDecoder().decode(this.password));
        return JsonUtil.convert(this,User.class);
    }
}
