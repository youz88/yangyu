package com.yangyu.global.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by youz on 2017/11/6.
 */
@Getter
@AllArgsConstructor
public enum ConfigType {

    /** jwt秘钥Key */
    JWT_SECRET("SECRET_KEY","admin");

    private String key;

    /** 默认值 */
    private String value;

    public boolean isSecretKey(){
        return this == JWT_SECRET;
    }

}
