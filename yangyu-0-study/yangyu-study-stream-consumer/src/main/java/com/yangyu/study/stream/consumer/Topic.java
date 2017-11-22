package com.yangyu.study.stream.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Topic {

    String INPUT_TOPIC = "topic_in";

    @Input(INPUT_TOPIC)
    SubscribableChannel consume();

}
