package com.yangyu.news.user.model;

import com.yangyu.news.user.enums.AccountType;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by youz on 2017/10/27.
 */
@Entity
@Table(name = "news_user")
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

    @Column(length = 50)
    private String salt;

    @Column
    private Byte gender;

    @Column
    private Integer age;

    @Column(length = 100)
    private String opendId;

    @Column(length = 50)
    private String email;

    @Column(length = 30)
    private String phone;

//    @Column(name = "account_type")
//    @Enumerated(EnumType.ORDINAL)
//    private AccountType accountType;

    @Column
    private Boolean isLock;

    @Column
    private Boolean isDelete;

    @Column
    private Long createId;

    @Column
    private Long createDate;

    @Column
    private Long modifyId;

    @Column
    private Long modifyDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOpendId() {
        return opendId;
    }

    public void setOpendId(String opendId) {
        this.opendId = opendId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getModifyId() {
        return modifyId;
    }

    public void setModifyId(Long modifyId) {
        this.modifyId = modifyId;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }
}
