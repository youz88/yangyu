package com.yangyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Yangyu0ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(Yangyu0ConfigApplication.class, args);
	}
}
