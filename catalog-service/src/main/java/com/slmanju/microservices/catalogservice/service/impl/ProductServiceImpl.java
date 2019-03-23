package com.slmanju.microservices.catalogservice.service.impl;

import com.slmanju.microservices.catalogservice.domain.Product;
import com.slmanju.microservices.catalogservice.domain.ProductRepository;
import com.slmanju.microservices.catalogservice.service.ProductService;
import com.slmanju.microservices.catalogservice.service.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductView> findAll() {
        return productRepository.findAll()
                .stream()
                .map(Product::view)
                .collect(toList());
    }

    @Override
    public ProductView findById(String id) {
        return productRepository.findById(id).map(Product::view).orElse(null);
    }

}
