package com.ecommerce.form;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class UpdateProductOptionForm {
    private String color;
    private double price;
    private double priceSale;
    private int quantity;
    private int ram;
    private String image;
}
