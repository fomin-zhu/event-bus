package com.fomin.demo.service;

import com.fomin.demo.listener.ProductListener;
import com.fomin.demo.domain.entity.Product;
import com.fomin.demo.domain.event.ProductEvent;
import com.fomin.demo.manager.ProductManager;
import com.fomin.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fomin
 * @since 2020/6/30
 */
@Service
public class ProductService {

    @Autowired
    private ProductManager manager;

    public void getProduct(String name) {
        manager.create( name);

    }
}
