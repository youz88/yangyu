package com.yangyu.web.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by youz on 2017/11/2.
 */
public class GrantedAuthorityImpl implements GrantedAuthority{

    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
