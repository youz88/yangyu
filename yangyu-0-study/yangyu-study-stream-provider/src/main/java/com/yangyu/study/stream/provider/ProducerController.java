package com.yangyu.study.stream.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Created by youz on 2017/11/28.
 */
@RestController
public class ProducerController {

    public static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    @Autowired
    private SendService service;

    @Autowired
    LogPublishChannel logChannel;

    @GetMapping(value = "/send/{msg}")
    public void send(@PathVariable("msg") String msg){
        System.out.println("-----------------");
        service.sendMessage(msg);
    }

    @GetMapping("publish")
    public void publish() {
        LogInfoDTO logInfo = new LogInfoDTO()
                .setTimestamp(Calendar.getInstance().getTimeInMillis())
                .setMsg(LocalDateTime.now().format(DATE_TIME_PATTERN));
        Message<LogInfoDTO> msg = MessageBuilder.withPayload(logInfo).build();
        logChannel.publish().send(msg);
    }


    @GetMapping("/test")
    public void test(){
        System.out.println("===========>test");
    }
}
