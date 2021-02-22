package com.example.dubbo.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author clx
 */
@Configuration
public class BaseRedisConfig {
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.pwd}")
	private String pwd;

	@Value("${spring.redis.database}")
	private int database;

	@Value("${spring.redis.maxIdle}")
	private int maxIdle;

	@Value("${spring.redis.minIdle}")
	private int minIdle;

	@Value("${spring.redis.maxTotal}")
	private int maxTotal;

	@Value("${spring.redis.maxWaitMillis}")
	private int maxWaitMillis;

	@Bean(name = "vrpRedisTemplate")
	public RedisTemplate<String, Object> vrpRedisTemplate() {
		JedisConnectionFactory jedisConnectionFactory = this.buildJedisConnectionFactory();
		jedisConnectionFactory.afterPropertiesSet();
		return this.getRedisTemplate(jedisConnectionFactory);
	}

	/**
	 * build jedis connection factory
	 *
	 * @return
	 */
	private JedisConnectionFactory buildJedisConnectionFactory() {
		RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
		standaloneConfiguration.setHostName(host);
		standaloneConfiguration.setPort(port);
		standaloneConfiguration.setPassword(RedisPassword.of(pwd));
		standaloneConfiguration.setDatabase(database);

		JedisClientConfiguration.JedisClientConfigurationBuilder clientConfigurationBuilder = JedisClientConfiguration
				.builder();
		clientConfigurationBuilder.connectTimeout(Duration.ofMillis(200));
		clientConfigurationBuilder.readTimeout(Duration.ofMillis(200));

		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setMaxTotal(maxTotal);
		poolConfig.setMaxWaitMillis(maxWaitMillis);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		poolConfig.setTestWhileIdle(true);
		poolConfig.setNumTestsPerEvictionRun(15);
		poolConfig.setTimeBetweenEvictionRunsMillis(60000);
		clientConfigurationBuilder.usePooling().poolConfig(poolConfig);
		return new JedisConnectionFactory(standaloneConfiguration, clientConfigurationBuilder.build());
	}

	/**
	 * get RedisTemplate
	 *
	 * @param jedisConnectionFactory
	 * @return
	 */
	private RedisTemplate<String, Object> getRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		this.setSerializer(redisTemplate);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	/**
	 * String serializer
	 *
	 * @param template
	 */
	private void setSerializer(RedisTemplate<String, Object> template) {
		RedisSerializer<String> serializer = new StringRedisSerializer();
		template.setKeySerializer(serializer);
		template.setValueSerializer(serializer);
		template.setHashKeySerializer(serializer);
		template.setHashValueSerializer(serializer);
	}
}
