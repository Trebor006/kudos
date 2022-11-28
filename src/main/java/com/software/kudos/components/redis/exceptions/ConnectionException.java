package com.software.kudos.components.redis.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConnectionException extends Exception {

    public ConnectionException(String message) {
        super(message);
    }
}
