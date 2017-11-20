package com.yangyu.fallback;

import com.yangyu.api.UserApi;
import com.yangyu.common.json.JsonResult;
import com.yangyu.user.api.dto.RegisterDto;
import com.yangyu.user.api.vo.UserInfoVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by youz on 2017/11/10.
 */
@Component
public class IUserFallback implements FallbackFactory<UserApi> {

    @Override
    public UserApi create(Throwable throwable) {
        return new UserApi() {
            @Override
            public JsonResult<UserInfoVo> info(Long id) {
                return JsonResult.fail("23333");
            }

            @Override
            public UserInfoVo selectByName(String userName) {
                return UserInfoVo.defaultUser();
            }

            @Override
            public JsonResult register(RegisterDto registerDto) {
                return JsonResult.fail("服务器无法响应，请稍后再试");
            }
        };
    }
}
