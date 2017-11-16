package com.yangyu;

import com.yangyu.common.util.A;
import com.yangyu.common.util.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class YangyuNewsServerApplication {

	@Bean
	public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(50);
		threadPoolTaskExecutor.setMaxPoolSize(1000);
		threadPoolTaskExecutor.setQueueCapacity(20000);	//线程池所使用的缓冲队列
		threadPoolTaskExecutor.setKeepAliveSeconds(300); //线程池维护线程所允许的空闲时间
		// AbortPolicy:直接抛出java.util.concurrent.RejectedExecutionException异常
		// CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度
		// DiscardOldestPolicy:抛弃旧的任务、暂不支持；会导致被丢弃的任务无法再次被执行
		// DiscardPolicy:抛弃当前任务、暂不支持；会导致被丢弃的任务无法再次被执行
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return threadPoolTaskExecutor;
	}

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
