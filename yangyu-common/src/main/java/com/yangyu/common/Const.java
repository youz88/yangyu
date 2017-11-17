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

    public static final Long ROOT_PERMISSION = 1L;

    public static final List<String> ROLE_DEFAULT = Collections.unmodifiableList(Arrays.asList("tourist"));

    public static final Long SUPER_ID = 0L;

    public static final String NEWS_HREF = "yangyu-2-news-href";

}
