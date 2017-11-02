//package com.yangyu.news.user.jwt;
//
//import com.yangyu.common.date.DateUtil;
//import com.yangyu.common.json.JsonUtil;
//import com.yangyu.common.util.U;
//import com.yangyu.global.model.JwtUser;
//import com.yangyu.news.user.model.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.apache.commons.lang.time.DateUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.nio.charset.StandardCharsets;
//import java.time.LocalDateTime;
//import java.util.Base64;
//import java.util.Date;
//
///**
// * Created by youz on 2017/10/31.
// */
//@Component
//public class JwtFactory {
//
//    @Autowired
//    private JwtProperties properties;
//
//    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
//
//
//    public String  createToken(User user, String secretKey,Integer exp){
//        U.assertNil(exp,"超时时间不能为空");
//        Date currentTime = DateUtil.now();
//        return Jwts.builder()
//                .setClaims()
//                .setIssuer(properties.getIssuer())
//                .setIssuedAt(currentTime)
//                .setExpiration(DateUtil.addSeconds(currentTime,properties.getExpirationTime()))
//                .signWith(SIGNATURE_ALGORITHM, Base64.getEncoder().encode(deserializeKey(secretKey)))
//                .compact();
//    }
//
//    public String  createToken(User user, String secretKey){
//        return createToken(user,secretKey,properties.getExpirationTime());
//    }
//
//    public JwtUser parseToken(String token, String secretKey){
//        Claims body = Jwts.parser()
//                .setSigningKey(Base64.getEncoder().encode(deserializeKey(secretKey)))
//                .parseClaimsJws(token)
//                .getBody();
//        return JsonUtil.convert(body,JwtUser.class);
//    }
//
//
//    private byte[] deserializeKey(String encodedKey) {
//        //TODO secretKey解码
//        return encodedKey.getBytes(StandardCharsets.UTF_8);
//    }
//
//}
