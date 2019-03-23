package com.slmanju.microservices.shoppingcartservice.controller;

import com.slmanju.microservices.shoppingcartservice.service.ShoppingCartService;
import com.slmanju.microservices.shoppingcartservice.service.view.Bill;
import com.slmanju.microservices.shoppingcartservice.service.view.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartController.class);

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/bill")
    public ResponseEntity<Bill> checkBill(@RequestBody Cart cart) {
        LOGGER.info(":: check bill ::");
        return ResponseEntity.ok(shoppingCartService.checkBill(cart));
    }

}
