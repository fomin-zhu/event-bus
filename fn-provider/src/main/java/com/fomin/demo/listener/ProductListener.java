package com.fomin.demo.listener;

import com.fomin.demo.ddd.DomainEventSubscriber;
import com.fomin.demo.model.event.ProductEvent;

/**
 * @author fomin
 * @since 2020/6/30
 */
public class ProductListener implements DomainEventSubscriber<ProductEvent> {

    @Override
    public void handle(ProductEvent event) {
        System.out.println("received order created event:{}." + event.getProduct().getName());
    }
}
