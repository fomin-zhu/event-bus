package com.fomin.demo.listener;

import com.fomin.demo.ddd.DomainEventSubscriber;
import com.fomin.demo.domain.event.ProductEvent;
import org.springframework.stereotype.Component;

/**
 * @author fomin
 * @since 2020/6/30
 */
@Component
public class ProductListener implements DomainEventSubscriber<ProductEvent> {

    @Override
    public void handle(ProductEvent event) {
        System.out.println("received order created event:{}." + event.getProduct().getName());
    }
}
