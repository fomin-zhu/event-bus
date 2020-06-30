package com.fomin.demo.manager;

import com.fomin.demo.domain.Factory;
import com.fomin.demo.domain.entity.Product;
import com.fomin.demo.domain.event.ProductEvent;
import com.fomin.demo.listener.ProductListener;
import com.fomin.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fomin
 * @since 2020/6/30
 */
@Component
public class ProductManager {
    @Autowired
    private Factory factory;
    @Autowired
    private ProductRepository repository;

    public void create(String name) {
        Product product = factory.buildProduct(repository.insert(name));
        product.setName(name);
        product.create(new ProductEvent(product));
    }
}
