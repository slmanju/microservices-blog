package com.slmanju.microservices.shoppingcartservice.service.impl;

import com.slmanju.microservices.shoppingcartservice.service.CatalogService;
import com.slmanju.microservices.shoppingcartservice.service.view.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CatalogServiceImpl implements CatalogService {

    @Value("${catalog.service.id}")
    private String catalogById;

    @Override
    public Product findProduct(String id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> response = restTemplate.getForEntity(catalogById, Product.class, id);
        return response.getBody();
    }

}
