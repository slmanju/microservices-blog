package com.slmanju.microservices.catalogservice.service.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductView {

    private String id;
    private Integer price;

}
