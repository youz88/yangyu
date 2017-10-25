package com.yangyu.study.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by youz on 2017/10/25.
 */

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Column(name = "create_date",nullable = false)
    private Long createDate;
}

