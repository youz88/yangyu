package com.yangyu.news.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by youz on 2017/10/27.
 */
@Getter
@AllArgsConstructor
public enum AccountType {

    /** 手机 */
    PHONE(0,"手机"),

    /** 手机 */
    EMAIL(1,"邮箱");

    private Integer code;
    private String value;

    public boolean isPhone(){
        return this == PHONE;
    }

    public boolean isEmail(){
        return this == EMAIL;
    }
}
