package com.yangyu.news.user.model;

import com.yangyu.news.user.enums.AccountType;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by youz on 2017/10/27.
 */
@Entity(name = "news_user")
@Getter
@Setter
@Builder
@Accessors(chain = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "real_name", length = 50)
    private String realName;

    @Column(length = 100)
    private String password;

    @Column
    private Byte gender;

    @Column
    private Integer age;

    @Column(length = 100)
    private String opendId;

    @Column(length = 50)
    private String phone;

    @Column(name = "account_type")
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;

    @Column
    private Long createId;

    @Column
    private Long createDate;

    @Column
    private Long modifyId;

    @Column
    private Long modifyDate;
}
