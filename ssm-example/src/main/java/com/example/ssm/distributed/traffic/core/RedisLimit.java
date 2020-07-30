package com.example.ssm.distributed.traffic.core;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * redis limit
 *
 * @author clx
 */
public class RedisLimit {

	/**
	 * JedisConnectionFactory
	 */
	private JedisConnectionFactory connectionFactory = null;
	/**
	 * limit threshold
	 */
	private int limitThreshold = 100;

	private RedisLimit(Builder builder) {
		this.connectionFactory = builder.connectionFactory;
		this.limitThreshold = builder.limit;
	}

	/**
	 * limit
	 *
	 * @return
	 */
	public boolean limit() {
		Object connection = this.getConnection();
		Object result = this.limitRequest(connection);
		return Long.parseLong(String.valueOf(result)) == 0;
	}

	private Object limitRequest(Object connection) {
		Object result = null;
		String key = String.valueOf(System.currentTimeMillis() / 1000);
		if (connection instanceof Jedis) {
			result = ((Jedis) connection).setnx(key, "1");
		} else {

		}
		return result;
	}

	/**
	 * redis connection
	 *
	 * @return
	 */
	private Object getConnection() {
		return connectionFactory.getConnection().getNativeConnection();
	}

	/**
	 * redis limit builder
	 */
	public static class Builder {
		/**
		 * JedisConnectionFactory
		 */
		private JedisConnectionFactory connectionFactory;
		/**
		 * limit threshold
		 */
		private int limit = 100;

		public Builder(JedisConnectionFactory connectionFactory) {
			this.connectionFactory = connectionFactory;
		}

		/**
		 * limit
		 *
		 * @param limitThreshold
		 * @return
		 */
		public Builder limit(int limitThreshold) {
			this.limit = limitThreshold;
			return this;
		}

		/**
		 * build redis limit
		 *
		 * @return
		 */
		public RedisLimit build() {
			return new RedisLimit(this);
		}
	}
}
