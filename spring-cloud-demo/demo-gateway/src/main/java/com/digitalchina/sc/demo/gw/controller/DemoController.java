package com.digitalchina.sc.demo.gw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalchina.sc.demo.gw.remoteservice.HelloService;

@RestController
public class DemoController {

	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/hello/{name}")
	public String sayHello(@PathVariable("name") String name) {
		return helloService.hello(name);
	}
}
