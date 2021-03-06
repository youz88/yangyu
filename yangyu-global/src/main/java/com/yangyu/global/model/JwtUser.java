package com.yangyu.global.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * JWT参数信息
 */
@Getter
@Setter
@Accessors(chain = true)
public class JwtUser extends UsernamePasswordAuthenticationToken {

    private Long id;

    private String nickName;

    private String userName;

    private String email;

    private String phone;

    private Boolean isLock;

    private Boolean authenticated;

    private Collection authorities;

    JwtUser(){
        super(null,null);
    }

    public JwtUser(Object principal, Object credentials){
        super(principal,credentials);
    }

    public JwtUser(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.authorities = super.getAuthorities();
        this.authenticated = super.isAuthenticated();
    }


}
