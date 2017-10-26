package com.yangyu.news.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class YangyuNewsDiscoveryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangyuNewsDiscoveryEurekaApplication.class, args);
	}
}
