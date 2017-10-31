package com.yangyu.news.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.yangyu.news.user")
public class YangyuNewsUserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangyuNewsUserServerApplication.class, args);
	}
}
