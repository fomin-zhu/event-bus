package com.fomin.demo.guaua;

import java.time.Instant;

/**
 * @author fomin
 * @since 2020/6/30
 */
public abstract class BaseEvent {
    private Instant currentTime;

    /**
     * 身份域
     *
     * @return 身份类型
     */
    protected abstract String identify();

    public BaseEvent() {
        currentTime = Instant.now();
    }

    public Instant getCurrentTime() {
        return currentTime;
    }
}
