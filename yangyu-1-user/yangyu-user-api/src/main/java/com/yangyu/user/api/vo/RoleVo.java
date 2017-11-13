package com.yangyu.user.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by youz on 2017/11/10.
 */
@Getter
@Setter
@NoArgsConstructor
public class RoleVo {

    @ApiModelProperty("角色ID")
    private Long id;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色标志")
    private String sign;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("是否已删除")
    private Boolean isDelete=false;

    @ApiModelProperty("排序")
    private Integer orders;

    public static List<RoleVo> defaultRole() {
        //TODO 默认角色
        return null;
    }
}
