package com.fomin.demo.service;

import com.fomin.demo.listener.ProductListener;
import com.fomin.demo.model.entity.Product;
import com.fomin.demo.model.event.ProductEvent;
import com.fomin.demo.repo.ProductRepository;
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
