package com.yangyu.global;

import com.yangyu.common.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by youz on 2017/11/7.
 */
@Component
public class AppProperties {

    @Value("${yangyu.jwt.expirationTime}")
    public Integer expirationTime;

    @Value("${yangyu.jwt.tokenHeader}")
    public String tokenHeader;

    @Value("${yangyu.jwt.tokenPrefix}")
    public String tokenPrefix;

    public static AppProperties getByAppContext() {
        return ApplicationContextUtil.getBean(AppProperties.class);
    }
}
