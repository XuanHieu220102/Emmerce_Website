package com.ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private int id;
    private String productName;
    private BrandDTO brand;
    private CategoryDTO category;
    List<ProductOptionsTmp> productOptions;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductOptionsTmp {
        private int optionId;
        private String color;
        private double price;
        private double priceSale;
        private String image;
        private int quantity;
        private int ram;
        private int productId;
    }
}
