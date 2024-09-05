package com.ecommerce.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateShopcartForm {
    private int userId;
    private int optionId;
    private int total;
}
