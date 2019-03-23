package com.slmanju.microservices.catalogservice.service;

import com.slmanju.microservices.catalogservice.service.view.ProductView;

import java.util.List;

public interface ProductService {

    List<ProductView> findAll();

    ProductView findById(String id);

}
