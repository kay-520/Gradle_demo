package com.digitalchina.sc.demo.gw.configurer.service;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 路由服务熔断处理,其熔断和springcloud的Hystrix不同
 * @author jiangxian
 *
 */
public class RouteFuse implements FallbackProvider{

	/**
	 * 指定针对那个路由进行的熔断处理，以yml中配置的为准，不支持url的方式，必须配合注册中心
	 */
	@Override
	public String getRoute() {
		return null;
	}

	/**
	 * 当失败时直接返回响应信息
	 */
	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return null;
	}

}
