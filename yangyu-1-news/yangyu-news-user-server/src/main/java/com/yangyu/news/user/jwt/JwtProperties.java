package com.yangyu.news.user.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by youz on 2017/11/2.
 */
@Configuration
@ConfigurationProperties(prefix = "jwt.security.token")
@Getter
@Setter
public class JwtProperties {

    /** 代表这个JWT的签发主体 */
    private String issuer;

    /** 代表这个JWT的主体，即它的所有人 */
    private String subject;

    /** 代表这个JWT的接收对象 */
    private String audience;

    /** 是一个时间戳，代表这个JWT的过期时间 */
    private Integer expirationTime;

//    /** 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的 */
//    private String not_before;
//
//    /** 是一个时间戳，代表这个JWT的签发时间 */
//    private String issued_at;
//
//    /** 是JWT的唯一标识 */
//    private String id;
}
