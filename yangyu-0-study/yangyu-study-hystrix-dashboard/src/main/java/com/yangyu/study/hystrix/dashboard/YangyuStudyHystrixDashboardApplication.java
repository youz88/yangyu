package com.yangyu.study.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class YangyuStudyHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangyuStudyHystrixDashboardApplication.class, args);
	}
}
