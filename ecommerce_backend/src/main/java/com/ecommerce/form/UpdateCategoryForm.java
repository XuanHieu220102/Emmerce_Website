package com.ecommerce.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class UpdateCategoryForm {
    @NotBlank
    private String name;
}
