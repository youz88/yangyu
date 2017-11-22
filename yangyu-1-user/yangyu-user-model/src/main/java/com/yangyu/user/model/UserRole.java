package com.yangyu.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by youz on 2017/11/8.
 */
@Entity
@Table(name = "yangyu_user_role")
@Getter
@Setter
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 用户ID */
    @Column
    private Long userId;

    /** 角色ID */
    @Column
    private Long roleId;
}
