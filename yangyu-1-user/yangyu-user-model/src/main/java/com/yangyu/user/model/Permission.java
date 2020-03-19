package com.yangyu.user.model;

import com.yangyu.user.enums.PermissionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限
 */
@Getter
@Setter
@Entity
@Table(name = "yangyu_permission")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 所属系统 */
    @Column
    private Long systemId;

    /** 所属上级ID */
    @Column
    private Long pid;

    /** 名称 */
    @Column(length = 50)
    private String permissionName;

    /** 类型{0:目录,1:菜单,2:按钮} */
    @Enumerated(value = EnumType.ORDINAL)
    private PermissionType permissionType;

    /** 权限值 */
    @Column(length = 50)
    private String permissionValue;

    /** 链接路径 */
    @Column(length = 100)
    private String url;

    /** 组件名称 */
    @Column(length = 50)
    private String component;

    /** 图标 */
    @Column(length = 20)
    private String icon;

    /** 是否已删除 */
    @Column
    private Boolean isDelete=false;

    /** 排序 */
    @Column
    private Integer orders;

    @Column
    private Long createId;

    @Column
    private Long createDate;

    @Column
    private Long modifyId;

    @Column
    private Long modifyDate;

}
