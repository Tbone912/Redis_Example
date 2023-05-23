package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.service.Receiver;

@SpringBootApplication
public class RedisExampleApplication {
	
	

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisExampleApplication.class);
	public static String messageToSend = "null";
	

	public static void main(String[] args) throws InterruptedException {

		ApplicationContext ctx = SpringApplication.run(RedisExampleApplication.class, args);

		

//		System.exit(0);
	}
}