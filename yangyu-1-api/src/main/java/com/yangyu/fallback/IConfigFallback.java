package com.yangyu.fallback;

import com.yangyu.api.ConfigApi;
import com.yangyu.global.enums.ConfigType;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by youz on 2017/11/6.
 */
@Component
public class IConfigFallback implements FallbackFactory<ConfigApi> {

    @Override
    public ConfigApi create(Throwable throwable) {
        return new ConfigApi() {
            @Override
            public String getValue(ConfigType configType) {
                if(configType.isSecretKey()){
                    return configType.getValue();
                }
                return null;
            }
        };
    }
}
