package com.fomin.demo.model.entity;

import com.fomin.demo.ddd.BaseEntity;
import com.fomin.demo.listener.ProductListener;
import com.fomin.demo.model.event.ProductEvent;
import com.fomin.demo.repo.ProductRepository;

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
