package com.yangyu.user.web.vo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.yangyu.common.Const;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.global.model.JwtUser;
import com.yangyu.user.enums.PermissionType;
import com.yangyu.user.model.Permission;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

/**
 * Created by youz on 2017/11/9.
 */
@Getter
@Setter
public class PermissionVo {

    private Long id;

    /** 所属系统 */
    private Long systemId;

    /** 所属上级ID */
    private Long pid;

    /** 名称 */
    private String permissionName;

    /** 类型{0:目录,1:菜单,2:按钮} */
    private PermissionType permissionType;

    /** 权限值 */
    private String permissionValue;

    /** 链接路径 */
    private String url;

    /** 图标 */
    private String icon;

    /** 是否已删除 */
    private Boolean isDelete=false;

    private List<PermissionVo> child=Lists.newArrayList();

    public static Collection<PermissionVo> assemblyData(List<Permission> list){
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
