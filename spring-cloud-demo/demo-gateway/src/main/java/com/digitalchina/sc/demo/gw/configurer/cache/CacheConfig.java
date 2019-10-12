package com.digitalchina.sc.demo.gw.configurer.cache;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 缓存配置
 * 
 * @author warrior
 * 2018年5月21日
 */
@Configuration
public class CacheConfig {

	// 缓存管理器
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {

		RedisCacheConfiguration defaultCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofHours(1))
				.serializeKeysWith(
						RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer()));
		RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.RedisCacheManagerBuilder
				.fromConnectionFactory(redisConnectionFactory).cacheDefaults(defaultCacheConfiguration);
		return builder.build();
	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		// 设置value的序列化规则和 key的序列化规则
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(redisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	public RedisSerializer<Object> redisSerializer() {
		return new GenericJackson2JsonRedisSerializer();
	}
}
