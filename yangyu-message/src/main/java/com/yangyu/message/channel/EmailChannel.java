package com.yangyu.message.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EmailChannel {

    String EMAIL = "email";

    @Input("email")
    SubscribableChannel email();
}
