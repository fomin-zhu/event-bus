package com.fomin.demo.repo;

import org.aspectj.apache.bcel.generic.RET;
import org.springframework.stereotype.Repository;

/**
 * @author fomin
 * @since 2020/6/30
 */
@Repository
public class ProductRepository {

    public long insert(String name) {
        System.out.println("insert product " + name);
        return 10;
    }
}
