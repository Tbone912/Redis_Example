package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.Listener;
import com.service.Receiver;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

	@Autowired
	Listener listener;
	
	@Autowired
	private ApplicationContext ctx;
	
	
	
	@PostMapping(value = "/publish")
	public void sendMessage(@RequestBody String message) throws InterruptedException {
		//listener.whatever("go");
		
		StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
		Receiver receiver = ctx.getBean(Receiver.class);

		
		while (receiver.getCount() == 0) {

			template.convertAndSend("chat", message);
//			Thread.sleep(500L);
		}

	}
	
	

}
