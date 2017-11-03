package com.yangyu.news.user.web.filter;

import com.yangyu.api.IConfig;
import com.yangyu.common.Const;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    IConfig sysConfig;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(Const.TOKEN_HEADER);

        if (header == null || !header.startsWith(Const.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(Const.TOKEN_HEADER);
        if (token != null) {
            // parse the token.
            String userName = Jwts.parser()
                    .setSigningKey(sysConfig.getValue(Const.SECRET_KEY))
                    .parseClaimsJws(token.replace(Const.TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (userName != null) {
                return new UsernamePasswordAuthenticationToken(userName, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
