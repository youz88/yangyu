package com.yangyu.news.user.web.vo;

import com.yangyu.common.json.JsonUtil;
import com.yangyu.news.user.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by youz on 2017/11/6.
 */
@Getter
@Setter
public class UserInfoVo {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("昵称")
    private String nickName;

    public static UserInfoVo assemblyData(User user){
        return JsonUtil.convert(user,UserInfoVo.class);
    }
}
