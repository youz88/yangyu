package com.yangyu.study.hystrix.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by youz on 2017/10/26.
 */
@Getter
@Setter
@Accessors(chain = true)
public class User implements Serializable{

    private Long id;

    private String userName;

    private String password;

    private Long createDate;

    public static User defaultModel(){
        return new User().setId(0L).setUserName("hello").setPassword("world").setCreateDate(new Date().getTime());
    }
}
