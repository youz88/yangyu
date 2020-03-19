package com.yangyu.web.controller;

import com.yangyu.common.date.DateUtil;
import com.yangyu.common.json.JsonUtil;
import com.yangyu.common.util.IdGen;
import com.yangyu.global.model.BaseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@EnableBinding(Source.class)
public class EmailController {

    @Autowired
    Source source;
    @Autowired


    @GetMapping("/send")
    public void sendMessage(@RequestParam String email) {
        BaseMessage baseMessage = new BaseMessage()
                .setOtype(BaseMessage.SendMode.Email)
                .setReceiver(email)
                .setId(1)
                .setSendTime(DateUtil.now())
                .getRegisteMessageTemplet(new IdGen(1).nextId()+"");
        Message<BaseMessage> build = MessageBuilder.withPayload(baseMessage).build();
        source.output().send(build);
    }
}
