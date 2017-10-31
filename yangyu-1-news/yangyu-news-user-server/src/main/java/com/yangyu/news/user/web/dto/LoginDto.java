package com.yangyu.news.user.web.dto;

import com.alibaba.fastjson.JSON;
import com.yangyu.common.util.BeanUtil;
import com.yangyu.news.user.enums.AccountType;
import com.yangyu.news.user.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
//        Assert.notNull(accountType,"账户类型不能为空");
        Assert.notNull(password,"密码不能为空");
//        if(accountType.isPhone()){
//            this.userName = phone;
//        }else if(accountType.isEmail()){
//            this.userName = email;
//        }
        this.password = new String(Base64.getDecoder().decode(password.getBytes(StandardCharsets.UTF_8)));
        return BeanUtil.copyProperties(this,User.class);
    }

    public static void main(String[] args) {

    }
}
