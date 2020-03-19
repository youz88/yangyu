package com.yangyu.fallback;

import com.yangyu.api.RoleApi;
import com.yangyu.user.api.vo.RoleVo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IRoleFallback implements FallbackFactory<RoleApi> {
    @Override
    public RoleApi create(Throwable throwable) {
        return new RoleApi() {

            @Override
            public List<RoleVo> selectByUser(Long id) {
                return RoleVo.defaultRole();
            }
        };
    }
}
