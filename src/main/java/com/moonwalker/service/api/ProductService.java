package com.moonwalker.service.api;

import com.moonwalker.model.Product;

public interface ProductService {

    Product create(Product product);

    void remove(Long id);

    Iterable<Product> findAll(boolean isDeleted);

}
