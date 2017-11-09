package com.yangyu.user.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by youz on 2017/10/27.
 */
public enum AccountType {

    /** 手机 */
    PHONE(0,"手机"),

    /** 手机 */
    EMAIL(1,"邮箱");

    private Integer code;
    private String value;

    AccountType(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    @JsonValue
    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public boolean isPhone(){
        return this == PHONE;
    }

    public boolean isEmail(){
        return this == EMAIL;
    }
}
