package com.digitalchina.sc.demo.gw.configurer.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * ================================================
 * <p>
 * Title: Spring WebMvc配置
 * <p>
 * Description:
 * <p>
 * Date: 2018/2/25 15:52
 * <p>
 * ================================================
 *
 * @author Hope Chen
 * @version 1.0
 * 
 * 前后分离就去掉此类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean<WebSiteMeshFilter> filter = new FilterRegistrationBean<>();
		WebSiteMeshFilter siteMeshFilter = new WebSiteMeshFilter();
		filter.setFilter(siteMeshFilter);
		return filter;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	

}
