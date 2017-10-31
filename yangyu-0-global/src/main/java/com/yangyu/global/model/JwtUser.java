package com.yangyu.global.model;



import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by youz on 2017/10/31.
 */

@Getter
@Setter
@Accessors(chain = true)
public class JwtUser implements Serializable{

    private Long id;

    private String userName;

    private String password;

    private String email;

    private String phone;

    private Boolean isLock;

    private String toJson() {
        return "{" +
                "id:" + id +
                ", userName:'" + userName + '\'' +
                ", password:'" + password + '\'' +
                ", email:'" + email + '\'' +
                ", phone:'" + phone + '\'' +
                ", isLock:" + isLock +
                '}';
    }

    public Map toMap(){
        return JSON.parseObject(this.toJson(),Map.class);
    }
}
