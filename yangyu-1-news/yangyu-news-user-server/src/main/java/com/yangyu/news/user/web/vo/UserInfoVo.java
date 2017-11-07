package com.yangyu.news.user.web.vo;

import com.yangyu.common.json.JsonUtil;
import com.yangyu.global.model.JwtUser;
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

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("联系电话")
    private String phone;

    @ApiModelProperty("是否已锁定")
    private Boolean isLock;

    public static UserInfoVo assemblyData(JwtUser user){
        return JsonUtil.convert(user,UserInfoVo.class);
    }
}
