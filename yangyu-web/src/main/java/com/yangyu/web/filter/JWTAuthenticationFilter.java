package com.yangyu.web.filter;

import com.yangyu.common.util.ApplicationContextUtil;
import com.yangyu.common.util.LogUtil;
import com.yangyu.common.util.U;
import com.yangyu.global.model.JwtUser;
import com.yangyu.web.constant.Config;
import com.yangyu.web.security.SpringSecurityUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthenticationFilter extends BasicAuthenticationFilter{

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Config config = ApplicationContextUtil.getBean(Config.class);
        String header = request.getHeader(config.getTokenHeader());

        if (header == null || !header.startsWith(config.getTokenPrefix())) {
            chain.doFilter(request, response);
            return;
        }

        JwtUser authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);

    }

    private JwtUser getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(ApplicationContextUtil.getBean(Config.class).getTokenHeader());
        if (token != null) {
            try {
                String userName = SpringSecurityUtil.getClaims().getSubject();
                if (userName != null) {
                    return new JwtUser(userName, null, new ArrayList<>());
                }
            }catch (ExpiredJwtException e){
                U.assertException(true,"token已经过期,请重新获取");
            }catch (Exception e){
                LogUtil.ROOT_LOG.error("JWT验签失败",e);
                U.assertException(true,"JWT签名不匹配");
            }
            return null;
        }
        return null;
    }
}
