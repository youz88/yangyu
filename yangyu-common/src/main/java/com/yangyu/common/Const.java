package com.yangyu.common;

/** 项目中会用到的常量 */
public final class Const {

    /** 当前项目的基本包名 */
    public static final String BASE_PACKAGE = "com.yangyu.common";

    /** pc 端传过来的 token 的 key, 下划线主要用来区分跟其他参数不同 */
    public static final String TOKEN = "_token";

    /** cors 支持的所有方法 */
    public static final String[] SUPPORT_METHODS = new String[] { "HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS" };

    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";
}
