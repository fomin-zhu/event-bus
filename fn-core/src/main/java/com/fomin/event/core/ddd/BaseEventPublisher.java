package com.fomin.event.core.ddd;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fomin
 * @since 2020/6/30
 */
public abstract class BaseEventPublisher implements DomainEventPublisher {
    private static final ConcurrentHashMap<Class<? extends DomainEvent>, List<DomainEventSubscriber<? extends DomainEvent>>> subscriberMap
            = new ConcurrentHashMap<>();

    public synchronized <T extends DomainEvent> void subscribe(Class<T> clazz, DomainEventSubscriber<T> subscriber) {
        List<DomainEventSubscriber<? extends DomainEvent>> domainEventSubscribers = subscriberMap.get(clazz);
        if (domainEventSubscribers == null) {
            domainEventSubscribers = Lists.newArrayList();
        }
        domainEventSubscribers.add(subscriber);
        subscriberMap.put(clazz, domainEventSubscribers);
    }

    @Override
    public <T extends DomainEvent> void publish(T domainEvent) {
        if (domainEvent == null) {
            throw new IllegalArgumentException("domain event is null");
        }
        List<DomainEventSubscriber<? extends DomainEvent>> subscribers = subscriberMap.get(domainEvent.getClass());
        if (subscribers != null && !subscribers.isEmpty()) {
            for (DomainEventSubscriber subscriber : subscribers) {
                subscriber.handle(domainEvent);
            }
        }
    }
}
