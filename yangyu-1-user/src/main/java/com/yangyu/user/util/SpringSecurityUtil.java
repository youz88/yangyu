package com.yangyu.user.util;

import com.yangyu.api.IConfig;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.ApplicationContextUtil;
import com.yangyu.common.util.LogUtil;
import com.yangyu.common.util.RequestUtils;
import com.yangyu.common.util.U;
import com.yangyu.global.AppProperties;
import com.yangyu.global.enums.ConfigType;
import com.yangyu.global.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Collection;

/**
 * Created by youz on 2017/11/3.
 */
public class SpringSecurityUtil {

    public static Claims getClaims() {
        return Jwts.parser()
                .setSigningKey(ApplicationContextUtil.getBean(IConfig.class).getValue(ConfigType.JWT_SECRET))
                .parseClaimsJws(RequestUtils.getRequest().getHeader(AppProperties.getByAppContext().tokenHeader).replace(AppProperties.getByAppContext().tokenPrefix, "").trim())
                .getBody();
    }

    public static JwtUser getJwtUser() {
        return JsonUtil.convert(getClaims(), JwtUser.class);
    }

    public static Collection getAuthorities(){
        String tokenHeader = RequestUtils.getRequest().getHeader(AppProperties.getByAppContext().tokenHeader);
        try {
            if(U.isNotBlank(tokenHeader)){
                return getJwtUser().getAuthorities();
            }
        }catch (Exception e){
            LogUtil.ROOT_LOG.error("解析JWT失败",e);
            return null;
        }
        return null;
    }

}
