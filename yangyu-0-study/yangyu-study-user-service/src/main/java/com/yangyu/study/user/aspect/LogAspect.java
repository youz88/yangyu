package com.yangyu.study.user.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * Created by youz on 2017/10/26.
 */
@Aspect
@Component
public class LogAspect {

    Logger __log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.yangyu.study.user.controller.*.*(..))")
    public void exceptionLog(){}

    @Around(value = "exceptionLog()")
    public void after(ProceedingJoinPoint pjp) throws Throwable {
        __log.info("方法执行前时间：{}", LocalTime.now());
        pjp.proceed();
        __log.info("方法执行后时间：{}", LocalTime.now());
    }
}
