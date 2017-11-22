package com.yangyu.web.filter;

import com.yangyu.common.util.U;
import com.yangyu.global.model.JwtUser;
import com.yangyu.web.constant.Config;
import com.yangyu.web.security.SpringSecurityUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by youz on 2017/11/2.
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter{

    @Autowired
    Config config;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(config.tokenHeader);

        if (header == null || !header.startsWith(config.tokenPrefix)) {
            chain.doFilter(request, response);
            return;
        }

        JwtUser authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);

    }

    private JwtUser getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(config.tokenHeader);
        if (token != null) {
            try {
                String userName = SpringSecurityUtil.getClaims().getSubject();
                if (userName != null) {
                    return new JwtUser(userName, null, new ArrayList<>());
                }
            }catch (ExpiredJwtException e){
                U.assertException(true,"token已经过期,请重新获取");
            }catch (Exception e){
                U.assertException(true,"JWT签名不匹配");
            }
            return null;
        }
        return null;
    }
}
