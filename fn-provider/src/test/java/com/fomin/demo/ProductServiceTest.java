package com.fomin.demo;

import com.fomin.demo.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author fomin
 * @since 2020/6/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootstrap.class)
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void testUserRegister() {
        productService.getProduct("fomin");
    }
}
