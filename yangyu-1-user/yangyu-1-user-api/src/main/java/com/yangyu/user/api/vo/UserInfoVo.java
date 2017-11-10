package com.yangyu.user.api.vo;

import com.yangyu.common.json.JsonUtil;
import com.yangyu.global.model.JwtUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by youz on 2017/11/6.
 */
@Getter
@Setter
@NoArgsConstructor
public class UserInfoVo {

    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("联系电话")
    private String phone;

    @ApiModelProperty("是否已锁定")
    private Boolean isLock;

    public static UserInfoVo assemblyData(Object user){
        return JsonUtil.convert(user,UserInfoVo.class);
    }

    public static UserInfoVo defaultUser() {
        //TODO 设置默认用户
        return null;
    }
}
