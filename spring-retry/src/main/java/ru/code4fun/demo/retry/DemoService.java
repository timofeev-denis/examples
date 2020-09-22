package ru.code4fun.demo.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface DemoService {

    @Retryable(maxAttempts = 8, backoff = @Backoff(delay = 100, multiplier = 2))
    void retryableMethod();

    @Recover
    void recover(OperationFailedException e);

}
