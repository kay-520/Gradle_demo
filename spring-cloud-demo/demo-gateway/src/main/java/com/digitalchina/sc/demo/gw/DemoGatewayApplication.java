package com.digitalchina.sc.demo.gw;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//启动zuul代理
@EnableZuulProxy
//网关不需要启动注册与发现
//@EnableDiscoveryClient
//启动feign远程调用
@EnableFeignClients
@EnableCaching//开启redis缓存服务
public class DemoGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGatewayApplication.class, args);
	}
}
