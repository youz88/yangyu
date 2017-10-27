package com.yangyu.news.user.web.dto;

import com.alibaba.fastjson.JSON;
import com.yangyu.common.util.BeanUtil;
import com.yangyu.news.user.enums.AccountType;
import com.yangyu.news.user.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by youz on 2017/10/27.
 */
@Getter
@Setter
public class LoginDto {

    private String phone;

    private String email;

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "账户类型不能为空")
    private AccountType accountType;

    public User userData(){
        if(accountType.isPhone()){

        }else if(accountType.isEmail()){

        }
        return BeanUtil.copyProperties(this,User.builder().build(),User.class);
    }
}
