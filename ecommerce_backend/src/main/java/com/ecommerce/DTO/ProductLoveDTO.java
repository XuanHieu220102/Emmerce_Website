package com.ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductLoveDTO {
    private int optionId;
    private double price;
    private double priceSale;
    private String image;
    private String productName;
}
