package com.yangyu.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangyu.api.ConfigApi;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.ApplicationContextUtil;
import com.yangyu.global.AppProperties;
import com.yangyu.global.enums.ConfigType;
import com.yangyu.global.model.JwtUser;
import com.yangyu.web.dto.LoginDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by youz on 2017/11/2.
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {


    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // 接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            LoginDto user = new ObjectMapper().readValue(req.getInputStream(), LoginDto.class);
            return authenticationManager.authenticate(
                    new JwtUser(user.getUsername(), user.getPassword()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) {
        String token = Jwts.builder()
                .addClaims(JsonUtil.convert((JwtUser)auth, Map.class))
                .setSubject(auth.getPrincipal().toString())
                .setExpiration(new Date(System.currentTimeMillis() + AppProperties.getByAppContext().expirationTime))
                .signWith(SignatureAlgorithm.HS512, getSecretKey())
                .compact();
        res.addHeader(AppProperties.getByAppContext().tokenHeader, AppProperties.getByAppContext().tokenPrefix + " " + token);
    }

    public String getSecretKey() {
        ConfigApi bean = ApplicationContextUtil.getBean(ConfigApi.class);
        return bean.getValue(ConfigType.JWT_SECRET);
    }
}
