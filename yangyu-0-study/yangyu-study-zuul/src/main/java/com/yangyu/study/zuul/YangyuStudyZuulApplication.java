package com.yangyu.study.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class YangyuStudyZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangyuStudyZuulApplication.class, args);
	}
}
