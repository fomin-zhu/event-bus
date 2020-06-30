package com.fomin.demo.ddd;

/**
 * @author fomin
 * @since 2020/6/30
 */
public interface DomainEventSubscriber<T extends DomainEvent> {
    /**
     * 订阅者处理事件
     *
     * @param event 领域事件
     */
    void handle(T event);
}
