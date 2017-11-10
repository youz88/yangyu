package com.yangyu.user.controller;

import com.yangyu.common.json.JsonUtil;
import com.yangyu.user.api.RoleServer;
import com.yangyu.user.api.vo.RoleVo;
import com.yangyu.user.service.RoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by youz on 2017/11/10.
 */
@RestController
@Api(value = "RoleApi", description = "角色API", tags = {"角色服务"})
public class RoleController implements RoleServer{

    @Autowired
    RoleService roleService;

    @Override
    public List<RoleVo> selectByUser(Long id) {
        return JsonUtil.convertList(roleService.selectByUser(id),RoleVo.class);
    }
}
