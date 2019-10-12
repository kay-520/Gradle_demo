package com.digitalchina.sc.demo.gw.configurer.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.Sm2TagRuleBundle;

import cn.hutool.core.util.StrUtil;

/**
 * <p>
 * ================================================
 * <p>
 * Title: sitemesh配置
 * <p>
 * Description:
 * <p>
 * Date: 2018/2/25 15:47
 * <p>
 * ================================================
 *
 * @author Hope Chen
 * @version 1.0
 * 
 * 前后分离就去掉此类
 */
public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {

	private List<String> excludedPaths = new ArrayList<>();

	// @Value("${livable.sitemesh.excludedPath}")
	private String excludedPath;

	public WebSiteMeshFilter() {
		setExcludedPaths();
	}

	public void setExcludedPaths() {
		excludedPath = excludedPath + ",/error/**,/static/**,/plugins/**";
		if (StrUtil.isNotEmpty(excludedPath)) {
			excludedPaths = Arrays.asList(excludedPath.split(StrUtil.COMMA));
		}
	}

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		// 自定义标签
		builder.addTagRuleBundles(new Sm2TagRuleBundle(), new ExtHtmlRuleBundle());
		// 拦截规则
		builder.addDecoratorPath("/login", "/decorator/header");
		builder.addDecoratorPath("/register", "/decorator/header");
        builder.addDecoratorPath("/agency", "/decorator/header");
		builder.addDecoratorPath("/societyhouse/list", "/decorator/header");
		builder.addDecoratorPath("/shop/*", "/decorator/header");
		builder.addDecoratorPath("/park/*", "/decorator/header");
		builder.addDecoratorPath("/societyhouse/policylist", "/decorator/header");
		builder.addDecoratorPath("/societyhouse/rent/list", "/decorator/header");
		builder.addDecoratorPath("/societyhouse/publish/n/rent", "/decorator/header");
		builder.addDecoratorPath("/societyhouse/rent/list/detail", "/decorator/header");
		builder.addDecoratorPath("/societyhouse/detail", "/decorator/header");
		builder.addDecoratorPath("/user/*", "/decorator/header");
		builder.addDecoratorPath("/password/forget", "/decorator/header");
		builder.addDecoratorPath("/service/*", "/decorator/header");
		builder.addDecoratorPath("/personal/*", "/decorator/personal");
		builder.addDecoratorPath("/publichouse/*", "/decorator/header");
		builder.addDecoratorPath("/ihirehouse/s/list", "/decorator/header");
		builder.addDecoratorPath("/policy/index", "/decorator/header");
		builder.addDecoratorPath("/policy/house", "/decorator/header");
		// 白名单
		for (String excludedPath : excludedPaths) {
			builder.addExcludedPath(excludedPath);
		}
	}
}
