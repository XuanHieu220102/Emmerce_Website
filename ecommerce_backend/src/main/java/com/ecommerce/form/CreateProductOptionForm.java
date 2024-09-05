package com.ecommerce.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductOptionForm {
    private String color;
    private double price;
    private double priceSale;
    private int quantity;
    private int ram;
    private String image;
    private int productId;
}
