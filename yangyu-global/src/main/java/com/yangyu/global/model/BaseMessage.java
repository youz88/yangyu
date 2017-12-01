package com.yangyu.global.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import com.yangyu.common.util.U;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class BaseMessage {

    private Integer id;
    /** 信息标题 */
    private  String title;
    /** 信息内容 */
    private  String content;
    /** 信息发送者 */
    private  String sender;
    /** 信息接受者 */
    private  String receiver;

    /** 发送方式 1短信，2邮件 */
    private  SendMode otype;
    /** 发送状态 (0未发送,1已发送) */
    private  Integer status;

    private Date sendTime;

    /** 发送次数 */
    private  Integer times;

    /** 发送结果 从第三方获取，但是不确定类型，所以类型为string */
    private String result;

    public enum SendMode {
        Sms(1, "短信"),
        Email(2, "邮件");
        int code;
        String value;
        SendMode(int code, String value) {
            this.code = code;
            this.value = value;
        }

        /** 显示用 */
        public String getValue() {
            return value;
        }
        /** 存进数据库时 */
        @JsonValue
        public int getCode() {
            return code;
        }
        /** 数据反序列化时调用 */
        @JsonCreator
        public static SendMode deserializer(Object obj) {
            return U.toEnum(SendMode.class, obj);
        }
        public boolean isSms() {
            return this == Sms;
        }
        public boolean isEmail() {
            return this == Email;
        }
    }

    /** 构造消息模板(需先设置发送方式) */
    @JsonIgnore
    public BaseMessage getRegisteMessageTemplet(String code){
        StringBuilder builder = new StringBuilder();
        if(this.otype.isEmail()){
            builder.append(receiver+"，你好：<br/>")
                    .append("为确保是您本人的操作，您已选择通过该邮件地址获取验证码验证身份。请在邮件验证码输入框输入下方的验证码：")
                    .append("<br/>"+code+"。<br/>")
                    .append("验证码会在邮件发送后30分钟过期。 <br/>")
                    .append("yangyu");
            this.content = builder.toString();
            this.title = "yangyu账号注册验证码";
        }
        return this;
    }
}
