package com.fomin.demo.guaua;

/**
 * @author fomin
 * @since 2020/6/30
 */
public interface EventPublisher<T extends BaseEvent> {

    /**
     * 获取身份域
     * @return 身份
     */
    String identify();

    /**
     * 订阅事件
     * @param listener 事件监听
     */
    void register(Object listener);

    /**
     * 同步发送
     * @param event 事件
     */
    void publish(T event);

    /**
     * 异步发送
     * @param event 事件
     */
    void asyncPublish(T event);
}
