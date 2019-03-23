package com.slmanju.microservices.shoppingcartservice.service;

import com.slmanju.microservices.shoppingcartservice.service.view.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog-service", url = "http://localhost:8010")
public interface CatalogServiceFeign {

    @GetMapping("/{id}")
    Product findProduct(@PathVariable("id") String id);

}
