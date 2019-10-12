package com.digitalchina.sc.demo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//开启缓存服务
@EnableCaching
//如果使用了feign，则需要开启下面的
//@EnableFeignClients
public class ApiServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
	}

}
