package com.ecommerce.controller;

import com.ecommerce.DTO.ProductOptionDTO;
import com.ecommerce.entity.ProductOption;
import com.ecommerce.form.CreateProductOptionForm;
import com.ecommerce.form.UpdateProductOptionForm;
import com.ecommerce.service.IProductOptionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product-options")
@CrossOrigin("*")
public class ProductOptionController {
    @Autowired
    private IProductOptionService productOptionService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{productId}")
    public ResponseEntity<?> getAllProductOptions(@PathVariable int productId) {
        List<ProductOption> productOptions = productOptionService.getProductOptionsByProductId(productId);
        List<ProductOptionDTO> productOptionDTOs = modelMapper.map(productOptions, new TypeToken<List<ProductOptionDTO>>(){}.getType());
        return ResponseEntity.ok(productOptionDTOs);
    }

    @PostMapping
    public ResponseEntity<?> createNewProductOption(@RequestBody CreateProductOptionForm form) {
        ProductOption productOption = productOptionService.createNewProductOption(form);
        return ResponseEntity.ok("Add successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProductOption(
            @PathVariable int id,
            @RequestBody UpdateProductOptionForm form
            ) {
        ProductOption productOption = productOptionService.updateProductOption(id, form);
        return ResponseEntity.ok("Update successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductOption(@PathVariable int id) {
        productOptionService.deleteProductOptionById(id);
        return ResponseEntity.ok("Deleted successfully.");
    }

    @DeleteMapping("/delete-by-product/{productId}")
    public ResponseEntity<?> deleteProductOptionByProductId(@PathVariable int productId){
        productOptionService.deleteProductOptionByProductId(productId);
        return ResponseEntity.ok("Deleted successfully.");
    }
}
