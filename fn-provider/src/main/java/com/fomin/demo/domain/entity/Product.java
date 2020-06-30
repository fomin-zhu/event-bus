package com.fomin.demo.domain.entity;

import com.fomin.demo.ddd.BaseEntity;
import com.fomin.demo.domain.event.ProductEvent;
import com.fomin.demo.repo.ProductRepository;

/**
 * @author fomin
 * @since 2020/6/30
 */
public class Product extends BaseEntity<Long, ProductRepository> {
    private String name;

    public Product(Long id, ProductRepository repo) {
        super(id, repo);
    }


    public void create(ProductEvent event) {
        // getRepo()
        System.out.println("create product.");
        publish(event);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
