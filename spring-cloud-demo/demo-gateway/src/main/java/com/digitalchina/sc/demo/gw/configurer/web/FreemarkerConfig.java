package com.digitalchina.sc.demo.gw.configurer.web;

import com.google.common.collect.Maps;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Map;
import java.util.Properties;

/**
 * <p>================================================
 * <p>Title: Freemarker配置
 * <p>Description:
 * <p>Date: 2018/2/25 15:47
 * <p>================================================
 *
 * @author Hope Chen
 * @version 1.0
 * 
 * 前后分离就去掉此类
 */
@Configuration
public class FreemarkerConfig {

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("classpath:/templates");
        Map<String, Object> variables = Maps.newHashMap();
        configurer.setFreemarkerVariables(variables);

        Properties settings = new Properties();
        settings.setProperty("default_encoding", "utf-8");
        settings.setProperty("number_format", "0.##");
        configurer.setFreemarkerSettings(settings);
        return configurer;
    }

}
