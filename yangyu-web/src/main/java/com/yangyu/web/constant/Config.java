package com.yangyu.web.constant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Getter
@Setter
public class Config {

    /** jwt秘钥Key */
    @Value("${jwt.secret.key:6324}")
    public String jwtSecretKey;

    @Value("${jwt.expirationTime:86400000}")
    public Integer expirationTime;

    @Value("${jwt.tokenHeader:Authorization}")
    public String tokenHeader;

    @Value("${jwt.tokenPrefix:Bearer}")
    public String tokenPrefix;
}
