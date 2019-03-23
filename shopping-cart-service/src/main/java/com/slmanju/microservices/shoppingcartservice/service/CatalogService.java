package com.slmanju.microservices.shoppingcartservice.service;

import com.slmanju.microservices.shoppingcartservice.service.view.Product;

public interface CatalogService {

    Product findProduct(String id);

}
