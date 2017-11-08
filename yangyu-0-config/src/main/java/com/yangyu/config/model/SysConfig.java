package com.yangyu.config.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by youz on 2017/11/2.
 */
@Entity
@Table(name = "sys_config")
@Getter
@Setter
public class SysConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`key`", length = 100)
    private String key;

    @Column(name = "`value`", length = 100)
    private String value;

    @Column
    private Boolean isDelete=false;
}
