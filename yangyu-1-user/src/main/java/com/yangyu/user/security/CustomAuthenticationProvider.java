package com.yangyu.user.security;

import com.yangyu.common.util.U;
import com.yangyu.global.model.JwtUser;
import com.yangyu.user.model.Role;
import com.yangyu.user.model.User;
import com.yangyu.user.service.RoleService;
import com.yangyu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youz on 2017/11/2.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 认证逻辑
        User user = userService.selectByName(name);
        if (null != user) {
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                // 这里设置权限和角色
                List<Role> roles = roleService.selectByUser(user.getId());
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                roles.forEach(role -> authorities.add(new GrantedAuthorityImpl(role.getSign())));
                // 生成令牌
                return new JwtUser(name, password, authorities)
                        .setId(user.getId())
                        .setEmail(user.getEmail())
                        .setPhone(user.getPhone())
                        .setIsLock(user.getIsLock())
                        .setNickName(user.getNickName());
            } else {
                U.assertException(true, "密码错误");
            }
        } else {
            U.assertException(true, "用户不存在");
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(JwtUser.class);
    }

}