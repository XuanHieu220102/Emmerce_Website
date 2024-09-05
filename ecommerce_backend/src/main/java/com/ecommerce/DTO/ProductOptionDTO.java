package com.ecommerce.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOptionDTO {
    private int id;
    private String color;
    private double price;
    private double priceSale;
    private int quantity;
    private int ram;
    private String image;
    private int productId;
}
