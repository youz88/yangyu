package com.yangyu.message.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by youz on 2017/11/29.
 */
public interface EmailChannel {

    String EMAIL = "email";

    @Input("email")
    SubscribableChannel email();
}
