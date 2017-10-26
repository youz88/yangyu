package com.yangyu.study.ribbon.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by youz on 2017/10/26.
 */
@Getter
@Setter
public class User implements Serializable{

    private Long id;

    private String userName;

    private String password;

    private Long createDate;
}
