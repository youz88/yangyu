package com.yangyu.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by youz on 2017/10/27.
 * 用户
 */
@Entity
@Table(name = "yangyu_user")
@Getter
@Setter
@Accessors(chain = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 真实姓名 */
    @Column(length = 50)
    private String realName;

    /** 昵称 */
    @Column(length = 50)
    private String nickName;

    /** 密码 */
    @Column(length = 100)
    private String password;

    @Column(length = 50)
    private String salt;

    /** 性别{0:男,1:女} */
    @Column
    private Byte gender;

    /** 年龄 */
    @Column
    private Integer age;

    /** vx唯一id */
    @Column(length = 100)
    private String opendId;

    /** 邮箱 */
    @Column(length = 50)
    private String email;

    /** 联系电话 */
    @Column(length = 30)
    private String phone;

    /** 是否已锁定 */
    @Column
    private Boolean isLock = false;

    /** 是否已删除 */
    @Column
    private Boolean isDelete = false;

    @Column
    private Long createId;

    @Column
    private Long createDate;

    @Column
    private Long modifyId;

    @Column
    private Long modifyDate;
}
