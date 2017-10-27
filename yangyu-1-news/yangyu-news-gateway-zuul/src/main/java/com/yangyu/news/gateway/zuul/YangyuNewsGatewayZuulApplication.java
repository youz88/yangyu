package com.yangyu.news.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableCircuitBreaker
@ComponentScan("com.yangyu.news")
@EnableConfigurationProperties
public class YangyuNewsGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangyuNewsGatewayZuulApplication.class, args);
	}
}
