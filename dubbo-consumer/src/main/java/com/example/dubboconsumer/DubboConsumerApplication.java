package com.example.dubboconsumer;

import com.ohp.service.ProducterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDubbo
@RestController
@Slf4j
public class DubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApplication.class, args);
	}

	@DubboReference
	ProducterService producterService;
	@GetMapping("/")
	public String test(){
		return producterService.getTime(System.currentTimeMillis())+"";
	}
	@Bean
	public ConsumerConfig consumerConfig(){
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setCheck(false);
		consumerConfig.setTimeout(5000);
		return consumerConfig;
	}

}
