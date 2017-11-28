package com.yangyu.study;

import com.yangyu.study.stream.provider.LogPublishChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({
		LogPublishChannel.class
})
@SpringBootApplication
public class YangyuStudyStreamProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangyuStudyStreamProviderApplication.class, args);
	}
}
