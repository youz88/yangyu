package com.yangyu.api.fallback;

import com.yangyu.api.IConfig;
import com.yangyu.global.enums.ConfigType;
import org.springframework.stereotype.Component;

/**
 * Created by youz on 2017/11/6.
 */
@Component
public class IConfigFallback implements IConfig{


    @Override
    public String getValue(ConfigType configType) {
        if(configType.isSecretKey()){
            return configType.getValue();
        }
        return null;
    }
}
