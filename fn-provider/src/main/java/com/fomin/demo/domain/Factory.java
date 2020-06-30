package com.fomin.demo.domain;

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
public class Factory {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductListener productListener;

    public Product buildProduct(long id) {
        Product product = new Product(id, productRepository);
        product.subscribe(ProductEvent.class, productListener);
        return product;
    }
}
