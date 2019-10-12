package com.digitalchina.sc.demo.gw.configurer.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * 自定义的路由filter，可自行实现，包括权限，路由等信息
 * @author jiangxian
 *
 */
public class YourFilter extends ZuulFilter{

	/**
	 * 是否应该执行
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 具体执行事项
	 */
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 可定义pre,route,post,error四种阶段
	 * pre在请求被路由之前调用，一般用于权限校验等
	 * routeing，将请求路由到微服务
	 * post,路由到微服务后的执行，一般由于收集http响应头等信息
	 * error，其他阶段发射错误时执行
	 */
	@Override
	public String filterType() {
		return null;
	}

	/**
	 * filter是链式执行，值越小表示越先执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
