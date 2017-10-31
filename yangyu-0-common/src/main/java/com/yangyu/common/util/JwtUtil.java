package com.yangyu.common.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.util.Assert;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * Created by youz on 2017/10/31.
 */
public class JwtUtil {

    private static final Integer TIME_OUT = 20000;

    public static String  encode(Map<String,Object> claims, String secretKey, Integer exp){
        Assert.isNull(exp,"超时时间不能为空");
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(DateUtils.addMilliseconds(new Date(), exp))
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(secretKey.getBytes(StandardCharsets.UTF_8))) //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
    }

    public static String  encode(Map<String,Object> claims, String secretKey){
        return encode(claims,secretKey,TIME_OUT);
    }

    public static Map<String,Object> decode(String token, String secretKey){
        return  Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();
    }

}
