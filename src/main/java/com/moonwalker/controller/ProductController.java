package com.moonwalker.controller;

import com.moonwalker.model.Product;
import com.moonwalker.service.api.ProductService;
import java.net.URISyntaxException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("/create")
    public Product createOne(@RequestBody Product product)/* throws URISyntaxException */{
        return productService.create(product);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        productService.remove(id);
    }

    @GetMapping
    public Iterable<Product> findAll(
        @RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted) {
        return productService.findAll(isDeleted);
    }
}
