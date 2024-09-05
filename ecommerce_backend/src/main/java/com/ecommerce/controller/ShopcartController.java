package com.ecommerce.controller;

import com.ecommerce.DTO.ProductShopcartDTO;
import com.ecommerce.entity.ShopCart;
import com.ecommerce.form.CreateShopcartForm;
import com.ecommerce.form.UpdateShopcartForm;
import com.ecommerce.service.IShopCartService;
import com.ecommerce.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shopcart")
@CrossOrigin("*")
public class ShopcartController {
    @Autowired
    private IShopCartService shopCartService;

    @GetMapping("/{id}")
    public List<ProductShopcartDTO> getAllShopcartById(@PathVariable(name = "id") int id) {
        return shopCartService.getAllProductShopcartByUserId(id);
    }
    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createShopcart (@RequestBody CreateShopcartForm form) {
        System.out.println(form.getUserId());
        System.out.println(form.getOptionId());
        shopCartService.createShopcart(form);
        return ResponseEntity.ok("Thêm thành công");
    }

    @PutMapping()
    public ResponseEntity<?> updateShopcart(@RequestBody UpdateShopcartForm form) {
        shopCartService.updateShopCart(form);
        return ResponseEntity.ok("Update successfully");
    }

    @DeleteMapping("/{userId}/{optionId}")
    public ResponseEntity<?> deleteShopcart(
            @PathVariable int userId,
            @PathVariable int optionId
    ) {
        shopCartService.deleteShopCart(userId, optionId);
        return ResponseEntity.ok("Delete successfully");
    }
}
