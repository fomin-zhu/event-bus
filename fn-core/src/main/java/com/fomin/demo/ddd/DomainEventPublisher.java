package com.fomin.demo.ddd;

/**
 * @author fomin
 * @since 2020/6/30
 */
public interface DomainEventPublisher {

    /**
     * 事件发布
     *
     * @param event 事件
     */
    <T extends DomainEvent> void publish(T event);
}
