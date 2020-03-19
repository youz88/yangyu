package com.yangyu.web.security;

import com.yangyu.common.Const;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.ApplicationContextUtil;
import com.yangyu.common.util.LogUtil;
import com.yangyu.common.util.RequestUtils;
import com.yangyu.common.util.U;
import com.yangyu.global.model.JwtUser;
import com.yangyu.web.constant.Config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SpringSecurityUtil {

    public static Claims getClaims() {
        Config config = ApplicationContextUtil.getBean(Config.class);
        return Jwts.parser()
                .setSigningKey(config.getJwtSecretKey())
                .parseClaimsJws(RequestUtils.getRequest().getHeader(config.getTokenHeader()).replace(config.getTokenPrefix(), "").trim())
                .getBody();
    }

    public static JwtUser getJwtUser() {
        return JsonUtil.convert(getClaims(), JwtUser.class);
    }

    public static List<String> getAuthorities(){
        String tokenHeader = RequestUtils.getRequest().getHeader(ApplicationContextUtil.getBean(Config.class).getTokenHeader());
        try {
            if(U.isNotBlank(tokenHeader)){
                Collection<LinkedHashMap<String,String>> authorities = getJwtUser().getAuthorities();
                return authorities.stream().map(linkedHashMap -> linkedHashMap.get("authority")).collect(Collectors.toList());
            }
        }catch (Exception e){
            LogUtil.ROOT_LOG.error("解析JWT失败",e);
        }
        return Const.ROLE_DEFAULT;
    }

}
