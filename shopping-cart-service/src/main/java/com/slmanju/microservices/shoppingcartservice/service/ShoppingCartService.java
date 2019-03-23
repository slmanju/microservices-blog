package com.slmanju.microservices.shoppingcartservice.service;

import com.slmanju.microservices.shoppingcartservice.service.view.Bill;
import com.slmanju.microservices.shoppingcartservice.service.view.Cart;

public interface ShoppingCartService {

    Bill checkBill(Cart cart);

}
