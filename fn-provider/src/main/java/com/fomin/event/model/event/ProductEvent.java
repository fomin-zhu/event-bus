package com.fomin.event.model.event;

import com.fomin.event.core.ddd.DomainEvent;
import com.fomin.event.model.entity.Product;

import java.time.Instant;

/**
 * @author fomin
 * @since 2020/6/30
 */
public class ProductEvent implements DomainEvent {

    private Product product;

    public ProductEvent(Product product) {
        this.product = product;
    }

    @Override
    public Instant getCurrentTime() {
        return Instant.now();
    }

    public Product getProduct() {
        return product;
    }
}
