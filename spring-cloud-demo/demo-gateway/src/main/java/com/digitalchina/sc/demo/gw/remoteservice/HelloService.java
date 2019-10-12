package com.digitalchina.sc.demo.gw.remoteservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign远程调用示例
 * @author jiangxian
 *
 */
@FeignClient(name="注册在consul上的服务名称", fallback=HelloServiceHystrix.class)
public interface HelloService {

	@RequestMapping("/hello")
	public String hello(@RequestParam String name);
	
}
