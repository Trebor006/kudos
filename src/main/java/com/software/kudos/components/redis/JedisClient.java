package com.software.kudos.components.redis;

import com.software.kudos.components.redis.exceptions.ConnectionException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class JedisClient implements RedisClientInterface {

    private final String namespace = "KUDOS";
    private final JedisConnection redisConnection;

    @Override
    public Long addUpdateObjectOnNamespace(String id, String data) throws ConnectionException {
        var jedis = redisConnection.getJedisConnection();
        var result = jedis.hset(namespace, id, data);
        jedis.close();
        return result;
    }

    @Override
    public String getObject() throws ConnectionException {
        var jedis = redisConnection.getJedisConnection();
        var result = jedis.get(namespace);
        jedis.close();
        return result;
    }

    @Override
    public String getObjectById(String id) throws ConnectionException {
        var jedis = redisConnection.getJedisConnection();
        var result = jedis.hget(namespace, id);
        jedis.close();
        return result;
    }

    @Override
    public Long removeObjectOnNamespace(String id) throws ConnectionException {
        var jedis = redisConnection.getJedisConnection();
        var result = jedis.hdel(namespace, id);
        jedis.close();
        return result;
    }

    /**
     * @throws ConnectionException
     */
    @Override
    public Long removeKey() throws ConnectionException {
        var jedis = redisConnection.getJedisConnection();
        var result = jedis.del(namespace);
        jedis.close();
        return result;
    }
}
