package com.yangyu.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by youz on 2017/11/8.
 * 角色权限映射
 */
@Getter
@Setter
@Entity
@Table(name = "yangyu_role_permission")
public class RolePermission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 角色ID */
    @Column(name = "role_id")
    private Long roleId;

    /** 权限ID */
    @Column(name = "permission_id")
    private Long permissionId;
}
