package com.yangyu.common;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 项目中会用到的常量 */
public final class Const {

    /** 当前项目的基本包名 */
    public static final String BASE_PACKAGE = "com.yangyu.common";

    /** cors 支持的所有方法 */
    public static final String[] SUPPORT_METHODS = new String[] { "HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS" };

    /** 根菜单ID */
    public static final Long ROOT_PERMISSION = 1L;

    /** 默认游客角色 */
    public static final List<String> ROLE_DEFAULT = Collections.unmodifiableList(Arrays.asList("tourist"));

    /** 系统创建ID为0 */
    public static final Long SUPER_ID = 0L;

    public static final String NEWS_HREF = "yangyu-2-news-href";

}
