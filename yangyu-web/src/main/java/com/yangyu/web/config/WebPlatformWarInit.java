package com.yangyu.web.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.yangyu.common.Const;
import com.yangyu.common.converter.String2DateConverter;
import com.yangyu.common.converter.StringToEnumConverter;
import com.yangyu.common.converter.StringToNumberConverter;
import com.yangyu.common.converter.StringTrimAndEscapeConverter;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.A;
import com.yangyu.common.util.LogUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @see WebMvcConfigurerAdapter
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
 * @see org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter
 */
@Configuration
public class WebPlatformWarInit extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 从前台过来的数据转换成对应类型的转换器
        registry.addConverter(new StringTrimAndEscapeConverter());
        registry.addConverterFactory(new StringToNumberConverter());
        registry.addConverterFactory(new StringToEnumConverter());
        registry.addConverter(new String2DateConverter());
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (A.isNotEmpty(converters)) {
            converters.removeIf(converter -> converter instanceof StringHttpMessageConverter
                    || converter instanceof MappingJackson2HttpMessageConverter);
        }

        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        converters.add(new CustomizeJacksonConverter());
    }
    private static class CustomizeJacksonConverter extends MappingJackson2HttpMessageConverter {
        private CustomizeJacksonConverter() { super(JsonUtil.RENDER); }
        @Override
        protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
            super.writeSuffix(generator, object);
            if (LogUtil.ROOT_LOG.isInfoEnabled() && LogUtil.wasBind()) {
                LogUtil.ROOT_LOG.info("return json: {}", JsonUtil.toRender(object));
            }
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义的拦截器
//        registry.addInterceptor(new WebPlatformInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new PageListToPageInterceptor()).addPathPatterns("/**");
    }

    /**
     * see : http://www.ruanyifeng.com/blog/2016/04/cors.html
     *
     * {@link org.springframework.web.servlet.config.annotation.CorsRegistration#CorsRegistration(String)}
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods(Const.SUPPORT_METHODS);
    }
}
