package com.digitalchina.sc.demo.gw.remoteservice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloServiceHystrix implements HelloService{

	@Override
	public String hello(@RequestParam String name) {
		return "被熔断了";
	}

}
