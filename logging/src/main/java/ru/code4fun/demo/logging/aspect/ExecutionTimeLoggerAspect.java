package ru.code4fun.demo.logging.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class ExecutionTimeLoggerAspect {

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch watch = new StopWatch();
        watch.start(joinPoint.toShortString());
        try {
            return joinPoint.proceed();
        } finally {
            watch.stop();
            log.debug("{} execution time: {} ns", joinPoint.getSignature().toShortString(), watch.getTotalTimeNanos());
        }
    }
}
