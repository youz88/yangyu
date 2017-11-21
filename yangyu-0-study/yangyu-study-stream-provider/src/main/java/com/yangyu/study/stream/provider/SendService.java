package com.yangyu.study.stream.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by youz on 2017/11/21.
 */
@EnableBinding(Source.class)
public class SendService {

    @Autowired
    private Source source;

    public void sendMessage(String msg) {
        try {
            source.output().send(MessageBuilder.withPayload(msg).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


