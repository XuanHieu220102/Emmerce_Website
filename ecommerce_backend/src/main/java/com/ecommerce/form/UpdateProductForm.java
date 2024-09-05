package com.ecommerce.form;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class UpdateProductForm {
    @NotBlank
    private String name;
    @NotBlank
    private int brandId;
    @NotBlank
    private int categoryId;
}
