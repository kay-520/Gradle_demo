package com.digitalchina.sc.demo.gw.configurer.cache;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 配置redis-session，配置完这个开发者不需要配置其他，本地session就可以基于redis实现session同步共享
 * 如果不需要注释掉注解即可
 * @author 江贤
 *
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=1800)
public class RedisSessionConfig {
	
}
