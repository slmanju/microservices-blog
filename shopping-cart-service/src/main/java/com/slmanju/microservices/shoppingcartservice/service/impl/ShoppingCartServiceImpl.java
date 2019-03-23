package com.slmanju.microservices.shoppingcartservice.service.impl;

import com.slmanju.microservices.shoppingcartservice.service.CatalogService;
import com.slmanju.microservices.shoppingcartservice.service.ShoppingCartService;
import com.slmanju.microservices.shoppingcartservice.service.view.Bill;
import com.slmanju.microservices.shoppingcartservice.service.view.Cart;
import com.slmanju.microservices.shoppingcartservice.service.view.CartItem;
import com.slmanju.microservices.shoppingcartservice.service.view.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final CatalogService catalogService;

    @Autowired
    public ShoppingCartServiceImpl(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    public Bill checkBill(Cart cart) {
        Integer total = cart.getCartItems()
                .stream()
                .map(this::getTotal)
                .reduce(0, (result, source) -> result + source);
        return Bill.builder().totalAmount(total).build();
    }

    private Integer getTotal(CartItem cartItem) {
        Product product = catalogService.findProduct(cartItem.getProductId());
        return cartItem.getQuantity() * product.getPrice();
    }

}
