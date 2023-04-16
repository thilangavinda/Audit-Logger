package com.thilan.app.cpnfig;

import com.thilan.app.exception.CustomAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {
    @Value("${async.executor.corePoolSize:1}")
    private int corePoolSize;

    @Value("${async.executor.maxPoolSize:5}")
    private int maxPoolSize;

    @Value("${async.executor.queueCapacity:1}")
    private int queueCapacity;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(10);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        // refer https://www.baeldung.com/java-rejectedexecutionhandler for reject handling
        executor.setThreadNamePrefix("Async Executor -");
        executor.initialize();

        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }
}
