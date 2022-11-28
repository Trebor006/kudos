package com.software.kudos.components.redis;

import com.software.kudos.components.redis.exceptions.ConnectionException;

public interface RedisClientInterface {
    Long addUpdateObjectOnNamespace(String id, String data) throws ConnectionException;

    String getObject() throws ConnectionException;

    String getObjectById(String id) throws ConnectionException;

    Long removeObjectOnNamespace(String id) throws ConnectionException;

    Long removeKey() throws ConnectionException;
}
