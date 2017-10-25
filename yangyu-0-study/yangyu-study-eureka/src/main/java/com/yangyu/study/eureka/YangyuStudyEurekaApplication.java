package com.yangyu.study.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YangyuStudyEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangyuStudyEurekaApplication.class, args);
	}
}
