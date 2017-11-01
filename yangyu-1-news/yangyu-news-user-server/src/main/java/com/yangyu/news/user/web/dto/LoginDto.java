package com.yangyu.news.user.web.dto;

import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.U;
import com.yangyu.news.user.enums.AccountType;
import com.yangyu.news.user.model.User;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by youz on 2017/10/27.
 */
@Getter
@Setter
public class LoginDto {

    private String phone;

    private String email;

    private String password;

    private AccountType accountType;

    private String userName;

    public User userData(){
        U.assertNil(accountType,"账户类型不能为空");
        U.assertNil(password,"密码不能为空");
        if(accountType.isPhone()){
            this.userName = phone;
        }else if(accountType.isEmail()){
            this.userName = email;
        }
        this.password = new String(Base64.getDecoder().decode(password.getBytes(StandardCharsets.UTF_8)));
        return JsonUtil.convert(this,User.class);
    }
}
