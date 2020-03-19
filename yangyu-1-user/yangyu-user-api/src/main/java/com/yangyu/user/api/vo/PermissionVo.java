package com.yangyu.user.api.vo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yangyu.common.Const;
import com.yangyu.common.json.JsonUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class PermissionVo {

    @ApiModelProperty("权限ID")
    private Long id;

    @ApiModelProperty("所属系统")
    private Long systemId;

    @ApiModelProperty("所属上级ID")
    private Long pid;

    @ApiModelProperty("名称")
    private String permissionName;

    @ApiModelProperty("")
    private Integer permissionType;

    @ApiModelProperty("权限值")
    private String permissionValue;

    @ApiModelProperty("链接路径")
    private String url;

    @ApiModelProperty("组件")
    private String component;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("是否已删除")
    private Boolean isDelete=false;

    private List<PermissionVo> child=Lists.newArrayList();

    public static Collection<PermissionVo> assemblyData(List<?> list){
        List<PermissionVo> permissionVoList = JsonUtil.convertList(list, PermissionVo.class);
        Map<Long,PermissionVo> map = Maps.newHashMap();
        permissionVoList.stream().filter(p -> p.id != Const.ROOT_PERMISSION).forEach(p -> map.put(p.getId(),p));
        Iterator<PermissionVo> iterator = permissionVoList.iterator();
        while(iterator.hasNext()){
            PermissionVo next = iterator.next();
            if(map.containsKey(next.getPid())){
                PermissionVo permissionVo = map.get(next.getPid());
                permissionVo.child.add(next);
                map.put(next.pid, permissionVo);
                map.remove(next.getId());
            }

        }
        return map.values();
    }
}
