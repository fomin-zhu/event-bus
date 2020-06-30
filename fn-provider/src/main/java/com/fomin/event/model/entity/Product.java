package com.fomin.event.model.entity;

import com.fomin.event.BaseEntity;
import com.fomin.event.listener.ProductListener;
import com.fomin.event.model.event.ProductEvent;
import com.fomin.event.repo.ProductRepository;

/**
 * @author fomin
 * @since 2020/6/30
 */
public class Product extends BaseEntity<Long, ProductRepository> {
    private String name;

    public Product(Long id, ProductRepository repo, ProductListener listener) {
        super(id, repo);
        subscribe(ProductEvent.class, listener);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
