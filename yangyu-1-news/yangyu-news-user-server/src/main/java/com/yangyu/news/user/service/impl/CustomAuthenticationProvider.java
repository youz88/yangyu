package com.yangyu.news.user.service.impl;

import com.yangyu.news.user.model.GrantedAuthorityImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;

/**
 * Created by youz on 2017/11/2.
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 认证逻辑
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        if(null != userDetails){
            String encodePassword = DigestUtils.md5DigestAsHex((password).getBytes());
            if(userDetails.getPassword().equals(encodePassword)){
                // 这里设置权限和角色
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add( new GrantedAuthorityImpl("ROLE_ADMIN") );
                authorities.add( new GrantedAuthorityImpl("AUTH_WRITE") );
                // 生成令牌
                Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
                return auth;
            }else {
                throw new BadCredentialsException("密码错误~");
            }
        }else {
            throw new UsernameNotFoundException("用户不存在~");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
