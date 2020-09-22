package ru.code4fun.demo.retry;

import org.springframework.retry.backoff.BackOffContext;

/**
 * BackOff context that stores attempt number
 */
class CustomBackOffContext implements BackOffContext {
    private Integer attempt = 0;

    public Integer getAttempt() {
        return this.attempt++;
    }
}
