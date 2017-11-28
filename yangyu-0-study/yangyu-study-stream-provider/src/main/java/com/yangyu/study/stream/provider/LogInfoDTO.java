package com.yangyu.study.stream.provider;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by youz on 2017/11/28.
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class LogInfoDTO {
    private long timestamp;
    private String msg;
}
