package com.khamid.userservice.common.exps;

public class NotFound extends RuntimeException {
    public NotFound(String message) {
        super(message);
    }
}
