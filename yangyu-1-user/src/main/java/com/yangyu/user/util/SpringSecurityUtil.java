package com.yangyu.user.util;

import com.yangyu.api.IConfig;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.ApplicationContextUtil;
import com.yangyu.common.util.RequestUtils;
import com.yangyu.global.AppProperties;
import com.yangyu.global.enums.ConfigType;
import com.yangyu.global.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

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

    public static void main(String[] args) {
        String json = "{\"authorities\":[{\"authority\":\"ROLE_ADMIN\"},{\"authority\":\"AUTH_WRITE\"}],\"authenticated\":true,\"principal\":\"admin\",\"id\":1,\"nickName\":\"游客\",\"phone\":\"123456\",\"isLock\":false,\"name\":\"admin\",\"sub\":\"admin\",\"exp\":1510130888}";
        System.out.println(JsonUtil.toJson(JsonUtil.toObject(json,JwtUser.class)));
    }

}
