package com.ecommerce.service;

import com.ecommerce.DTO.ProductShopcartDTO;
import com.ecommerce.entity.ShopCart;
import com.ecommerce.form.CreateShopcartForm;
import com.ecommerce.form.UpdateShopcartForm;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;

@Service
public interface IShopCartService {
    ShopCart createShopcart(CreateShopcartForm form);

    List<ProductShopcartDTO> getAllProductShopcartByUserId(int userId);

    void updateShopCart(UpdateShopcartForm form);

    void deleteShopCart(int userId, int optionId);
}
