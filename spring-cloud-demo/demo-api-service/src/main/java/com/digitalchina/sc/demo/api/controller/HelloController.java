package com.digitalchina.sc.demo.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
//swagger文档说明
@Api(value="HelloController|测试使用的例子")
public class HelloController {

	@ApiOperation(value="打招呼例子", notes="根据条件输出响应")
	@ApiImplicitParam(name="name", value="测试名称", required=true, dataType="String")
	@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		return "hello " + name;
	}
}
