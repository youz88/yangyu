package com.yangyu;

import com.yangyu.common.util.A;
import com.yangyu.common.util.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class YangyuNewsUserServerApplication extends SpringBootServletInitializer {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YangyuNewsUserServerApplication.class);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(YangyuNewsUserServerApplication.class, args);
		if (LogUtil.ROOT_LOG.isDebugEnabled()) {
			String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
			if (A.isNotEmpty(activeProfiles)) {
				LogUtil.ROOT_LOG.debug("current profile : ({})", A.toStr(activeProfiles));
			}
		}
	}
}
