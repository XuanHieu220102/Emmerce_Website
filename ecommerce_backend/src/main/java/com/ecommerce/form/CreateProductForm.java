package com.ecommerce.form;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductForm {
    @NotBlank
    private String name;
    @NotBlank
    private int brandId;
    @NotBlank
    private int categoryId;

}
