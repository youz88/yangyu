package com.yangyu.study.stream.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youz on 2017/11/21.
 */
@RestController
public class ProducerController {

    @Autowired
    private SendService service;

    @RequestMapping(value = "/send/{msg}", method = RequestMethod.GET)
    public void send(@PathVariable("msg") String msg){
        service.sendMessage(msg);
    }

}
