package com.fomin.event.core.guaua;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fomin
 * @since 2020/6/30
 */
public abstract class GuavaEventPublisher implements EventPublisher {
    private final EventBus syncBus = new EventBus(identify());
    private final EventBus asyncBus = new AsyncEventBus(identify(), createExecutorService());

    @Override
    public void register(Object listener) {
        syncBus.register(listener);
        asyncBus.register(listener);
    }

    @Override
    public void publish(BaseEvent event) {
        syncBus.post(event);
    }

    @Override
    public void asyncPublish(BaseEvent event) {
        asyncBus.post(event);
    }

    private ExecutorService createExecutorService() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("domain-pool-%d").build();
        return new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
    }
}
