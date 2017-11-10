package com.yangyu.config.controller;

import com.yangyu.common.json.JsonResult;
import com.yangyu.common.util.U;
import com.yangyu.config.model.SysConfig;
import com.yangyu.config.repository.SysConfigRepository;
import com.yangyu.global.enums.ConfigType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/11/2.
 */
@RestController
@RequestMapping("/sysConfig")
public class SysConfigController {

    @Autowired
    SysConfigRepository sysConfigRepository;

    @PostMapping("/value")
    public String selectValueByKey(ConfigType configType){
        SysConfig sysConfig = sysConfigRepository.selectByKey(configType.getKey());
        U.assertNil(sysConfig,"该配置不存在");
        return sysConfig.getValue();
    }
}
