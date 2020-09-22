package ru.code4fun.demo.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public void retryableMethod() {
        logger.debug("Вызов retryableMethod");
        throw new OperationFailedException("Бросаем исключение");
    }

    @Override
    public void recover(OperationFailedException e) {
        logger.debug("Вызов recover");
    }
}
