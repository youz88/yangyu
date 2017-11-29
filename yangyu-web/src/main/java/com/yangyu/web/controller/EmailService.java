package com.yangyu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by youz on 2017/11/29.
 */
@EnableBinding(Source.class)
public class EmailService {

    @Autowired
    Source source;

    public void sendMessage(String email) {
        try {
            System.out.println(email);
            source.output().send(MessageBuilder.withPayload(email).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
