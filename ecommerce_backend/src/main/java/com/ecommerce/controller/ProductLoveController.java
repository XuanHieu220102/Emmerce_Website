package com.ecommerce.controller;

import com.ecommerce.DTO.ProductShopcartDTO;
import com.ecommerce.entity.ShopCart;
import com.ecommerce.form.CreateLoveProductForm;
import com.ecommerce.form.CreateShopcartForm;
import com.ecommerce.service.IProductLoveService;
import com.ecommerce.service.IShopCartService;
import com.ecommerce.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product-love")
@CrossOrigin("*")
public class ProductLoveController {
    @Autowired
    private IProductLoveService productLoveService;

    @GetMapping("/{id}")
    public List<ProductShopcartDTO> getAllShopcartById(@PathVariable(name = "id") int id) {
        return productLoveService.getAllProductLoveByUserId(id);
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createShopcart (@RequestBody CreateLoveProductForm form) {
        System.out.println(form.getUserId());
        System.out.println(form.getOptionId());
        productLoveService.createProductLove(form);
        return ResponseEntity.ok("Thêm thành công");
    }

    @DeleteMapping("/{userId}/{optionId}")
    public ResponseEntity<?> deleteShopcart(
            @PathVariable int userId,
            @PathVariable int optionId
    ) {
        productLoveService.deleteProductLove(userId, optionId);
        return ResponseEntity.ok("Delete successfully");
    }
}
