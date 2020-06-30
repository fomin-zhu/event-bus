package com.fomin.event;

import com.fomin.event.core.ddd.BaseEventPublisher;

/**
 * @author fomin
 * @since 2020/6/30
 */
public abstract class BaseEntity<T, R> extends BaseEventPublisher {
    private T id;

    private R repo;

    public T getId() {
        return id;
    }

    protected R getRepo() {
        return repo;
    }

    public BaseEntity(T id, R repo) {
        this.id = id;
        this.repo = repo;
    }
}
