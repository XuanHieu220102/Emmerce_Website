package com.ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductShopcartDTO {
    private int optionId;
    private String color;
    private double price;
    private double priceSale;
    private int total;
    private int quantity;
    private int ram;
    private String image;
    private String productName;
}
