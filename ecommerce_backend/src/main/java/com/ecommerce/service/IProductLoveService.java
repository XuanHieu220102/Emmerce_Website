package com.ecommerce.service;

import com.ecommerce.DTO.ProductShopcartDTO;
import com.ecommerce.entity.ProductLove;
import com.ecommerce.entity.ShopCart;
import com.ecommerce.form.CreateLoveProductForm;
import com.ecommerce.form.CreateShopcartForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductLoveService {
    ProductLove createProductLove(CreateLoveProductForm form);

    List<ProductShopcartDTO> getAllProductLoveByUserId(int userId);
    public void deleteProductLove(int userId, int optionId);

    }
