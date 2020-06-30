package com.fomin.event.service;

import com.fomin.event.listener.ProductListener;
import com.fomin.event.model.entity.Product;
import com.fomin.event.model.entity.User;
import com.fomin.event.model.event.ProductEvent;
import com.fomin.event.model.event.UserEvent;
import com.fomin.event.publisher.UserPublisher;
import com.fomin.event.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fomin
 * @since 2020/6/30
 */
@Service
public class ProductService {

    public void getProduct(String name) {
        Product product = new Product(1L, new ProductRepository(), new ProductListener());
        product.setName(name);
        product.publish(new ProductEvent(product));
    }
}
