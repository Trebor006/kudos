package com.software.kudos.components.redis;

import com.software.kudos.components.redis.exceptions.ConnectionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

@Slf4j
@Component
public class JedisConnection {
    @Value("${redis.host.default}")
    private String host;
    @Value("${redis.port.default}")
    private int port;
    private JedisPool jedisPool;

    public Jedis getJedisConnection() throws ConnectionException {
        try {
            if (this.jedisPool == null) {
                log.info("Start Redis connection process.");
                log.debug(String.format("The connection parameters are Host '%1$s' and Port '%2$s'.", host, port));
                log.info("Connecting with Redis Service...");

                this.jedisPool = new JedisPool(new HostAndPort(host, port), DefaultJedisClientConfig.builder().build());
                log.info("Redis Connection is OK.");
            }

            return this.jedisPool.getResource();
        } catch (JedisException ex) {
            log.error("Redis Connection: " + ex.getMessage());
            log.error("Redis Connection: " + ex);
            throw new ConnectionException(ex.getMessage());
        }
    }
}
