package com.jeiker.demo.task;

import com.jeiker.demo.model.User;
import com.jeiker.demo.service.impl.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * spring task 定时任务测试，适用于单系统
 * 注意：不适合用于集群
 */
@Component
public class TestTask {
	protected Logger logger = LogManager.getLogger(getClass());
	
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private TestService testService;

	@Scheduled(cron = "0/5 * * * * ?")
	public void cronTest() {
		logger.debug("===> 执行定时任务.");
		// 测试手动存储cache
//		Cache cache = cacheManager.getCache("hour");

		// 测试redis
//		redisTemplate.boundListOps("xxxx").leftPush("xxxx");
		
		// 测试注解
		User user = testService.selectById(1L);

		logger.debug("===> user: {}",user);
	}
}
