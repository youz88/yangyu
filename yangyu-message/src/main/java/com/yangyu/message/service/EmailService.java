package com.yangyu.message.service;

import com.yangyu.common.util.LogUtil;
import com.yangyu.common.util.U;
import com.yangyu.global.model.BaseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

/**
 * Created by youz on 2017/11/29.
 */
@EnableBinding(Sink.class)
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @StreamListener(Sink.INPUT)
    public void processEmail(Message<BaseMessage> message) {
        BaseMessage payload = message.getPayload();
        if (!U.checkEmail(payload.getReceiver())) {
            if (LogUtil.ROOT_LOG.isErrorEnabled()) {
                LogUtil.ROOT_LOG.error("向({})发送邮件时发现邮箱地址无效", message.getPayload());
            }
            return;
        }
        if (U.isBlank(payload.getTitle()) || U.isBlank(payload.getContent())) {
            if (LogUtil.ROOT_LOG.isErrorEnabled()) {
                LogUtil.ROOT_LOG.error("向({})发送邮件时发现: 没有标题({})或者没有内容({})", payload.getReceiver(), payload.getTitle(), payload.getContent());
            }
            return;
        }
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.displayName());
            helper.setTo(payload.getReceiver());
            helper.setFrom(((JavaMailSenderImpl)mailSender).getUsername());
            helper.setSubject(payload.getTitle());
            // 后面的参数为 true 表示发送的是 html 格式的邮件
            helper.setText(payload.getContent(), true);
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            if (LogUtil.ROOT_LOG.isErrorEnabled())
                LogUtil.ROOT_LOG.error(String.format("向(%s)发送邮件(%s)时异常", payload.getReceiver(), payload.getTitle()), e);
            throw new RuntimeException(e);
        }
//        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
//        if (acknowledgment != null) {
//            System.out.println("Acknowledgment provided");
//            acknowledgment.acknowledge();
//        }
    }
}
