package com.yangyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YangyuTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangyuTaskApplication.class, args);
	}
}
