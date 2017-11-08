package com.yangyu.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by youz on 2017/11/8.
 */
@Getter
@AllArgsConstructor
public enum PermissionType {

    /** 目录 */
    DIRECTORY(0,"目录"),

    /** 菜单 */
    MENU(1,"菜单"),

    /** 按钮 */
    BUTTON(2,"按钮");

    private Integer code;
    private String value;

}
