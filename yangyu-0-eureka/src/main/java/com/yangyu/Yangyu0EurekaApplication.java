package com.yangyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Yangyu0EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Yangyu0EurekaApplication.class, args);
	}
}
