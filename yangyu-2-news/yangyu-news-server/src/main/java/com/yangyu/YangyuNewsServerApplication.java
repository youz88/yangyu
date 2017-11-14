package com.yangyu;

import com.yangyu.common.util.A;
import com.yangyu.common.util.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class YangyuNewsServerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(YangyuNewsServerApplication.class, args);
		if (LogUtil.ROOT_LOG.isDebugEnabled()) {
			String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
			if (A.isNotEmpty(activeProfiles)) {
				LogUtil.ROOT_LOG.debug("current profile : ({})", A.toStr(activeProfiles));
			}
		}
	}
}
