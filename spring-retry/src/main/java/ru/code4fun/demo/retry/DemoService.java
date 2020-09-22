package ru.code4fun.demo.retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface DemoService {

    @Retryable(backoff = @Backoff(delay = 1000))
    void retryableMethod();

    @Recover
    void recover(OperationFailedException e);

}
