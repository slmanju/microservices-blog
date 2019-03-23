package com.slmanju.microservices.shoppingcartservice.service.impl;

import com.slmanju.microservices.shoppingcartservice.service.CatalogService;
import com.slmanju.microservices.shoppingcartservice.service.CatalogServiceFeign;
import com.slmanju.microservices.shoppingcartservice.service.ShoppingCartService;
import com.slmanju.microservices.shoppingcartservice.service.view.Bill;
import com.slmanju.microservices.shoppingcartservice.service.view.Cart;
import com.slmanju.microservices.shoppingcartservice.service.view.CartItem;
import com.slmanju.microservices.shoppingcartservice.service.view.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

    private final CatalogService catalogService;
    private final CatalogServiceFeign catalogServiceFeign;

    @Autowired
    public ShoppingCartServiceImpl(CatalogService catalogService, CatalogServiceFeign catalogServiceFeign) {
        this.catalogService = catalogService;
        this.catalogServiceFeign = catalogServiceFeign;
    }

    @Override
    public Bill checkBill(Cart cart) {
        Integer total = cart.getCartItems()
                .stream()
                .map(this::getTotalFeign)
                .reduce(0, (result, source) -> result + source);
        return Bill.builder().totalAmount(total).build();
    }

    private Integer getTotalFeign(CartItem cartItem) {
        LOGGER.info(":: find product using feign client ::");
        Product product = catalogServiceFeign.findProduct(cartItem.getProductId());
        return cartItem.getQuantity() * product.getPrice();
    }

    private Integer getTotal(CartItem cartItem) {
        Product product = catalogService.findProduct(cartItem.getProductId());
        return cartItem.getQuantity() * product.getPrice();
    }

}
