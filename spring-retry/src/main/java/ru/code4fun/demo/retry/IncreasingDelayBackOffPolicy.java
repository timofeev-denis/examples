package ru.code4fun.demo.retry;

import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.*;

public class IncreasingDelayBackOffPolicy implements BackOffPolicy {
    private Sleeper sleeper = new ThreadWaitSleeper();

    @Override
    public BackOffContext start(RetryContext context) {
        return new CustomBackOffContext();
    }

    @Override
    public void backOff(BackOffContext backOffContext) throws BackOffInterruptedException {
        final CustomBackOffContext context = (CustomBackOffContext) backOffContext;
        try {
            sleeper.sleep(calculateSleepTime(context.getAttempt()));
        } catch (InterruptedException e) {
            throw new BackOffInterruptedException("Thread interrupted while sleeping", e);
        }
    }

    private long calculateSleepTime(Integer attempt) {
        if (attempt < 5) {
            return 100L;
        } else {
            return 1000L;
        }
    }
}
