package com.yangyu.news.user.config;

import com.yangyu.common.util.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

/** 项目中需要额外加载的类 */
@Configuration
public class WebPlatformBeanInit {


    @Bean
    public ApplicationContextUtil setupApplicationContext() {
        return new ApplicationContextUtil();
    }

    /** 处理字符的 filter. */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding(StandardCharsets.UTF_8.displayName());
        encodingFilter.setForceEncoding(true);

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(encodingFilter);
        return registrationBean;
    }

}
