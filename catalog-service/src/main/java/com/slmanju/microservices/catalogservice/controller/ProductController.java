package com.slmanju.microservices.catalogservice.controller;

import com.slmanju.microservices.catalogservice.service.ProductService;
import com.slmanju.microservices.catalogservice.service.view.ProductView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = { "", "/" })
    public ResponseEntity<List<ProductView>> findAll() {
        LOGGER.info(":: Find all products ::");
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductView> findById(@PathVariable("id") String id) {
        LOGGER.info(":: Find product by id {} ::", id);
        return ResponseEntity.ok(productService.findById(id));
    }

}
