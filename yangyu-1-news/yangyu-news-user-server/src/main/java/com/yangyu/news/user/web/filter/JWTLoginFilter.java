package com.yangyu.news.user.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yangyu.api.IConfig;
import com.yangyu.common.Const;
import com.yangyu.common.util.ApplicationContextUtil;
import com.yangyu.common.util.U;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by youz on 2017/11/2.
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    /** 超时时间 60 * 60 * 24 * 1000 */
    private final Integer TIME_OUT = 86400000;

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // 接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) {
        String token = Jwts.builder()
                .setSubject(((User)auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + TIME_OUT))
                .signWith(SignatureAlgorithm.HS512, getSecretKey())
                .compact();
        res.addHeader(Const.TOKEN_HEADER, Const.TOKEN_PREFIX + token);
    }

    public String getSecretKey() {
        IConfig bean = ApplicationContextUtil.getBean(IConfig.class);
        return U.isBlank(bean) ? "" : bean.getValue(Const.SECRET_KEY);
    }
}
