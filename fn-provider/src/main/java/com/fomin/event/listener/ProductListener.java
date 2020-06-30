package com.fomin.event.listener;

import com.fomin.event.core.ddd.DomainEventSubscriber;
import com.fomin.event.model.event.ProductEvent;

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
