package com.yangyu.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色
 */
@Getter
@Setter
@Entity
@Table(name = "yangyu_role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 角色名称 */
    @Column(length = 20)
    private String name;

    /** 角色标志 */
    @Column(length = 20)
    private String sign;

    /** 描述 */
    @Column(length = 50)
    private String description;

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
