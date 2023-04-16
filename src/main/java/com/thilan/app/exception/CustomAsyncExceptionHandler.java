package com.thilan.app.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
@Log4j2
public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.debug("Exception message - " + ex.getMessage());
        log.debug("Method name - " + method.getName());
        for (Object param : params) {
            log.debug("Parameter value - " + param);
        }
    }
}
