package com.slmanju.microservices.shoppingcartservice.service.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bill {

    private Integer totalAmount;

}
