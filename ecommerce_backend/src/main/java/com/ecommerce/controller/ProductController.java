package com.ecommerce.controller;

import com.ecommerce.DTO.ProductDTO;

import com.ecommerce.entity.Product;
import com.ecommerce.form.CreateProductForm;
import com.ecommerce.form.ProductFilterForm;
import com.ecommerce.form.UpdateProductForm;
import com.ecommerce.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@CrossOrigin("*")
public class ProductController {
    private final IProductService productService;

    @Autowired
    private ModelMapper modelMapper;
    @GetMapping
    public Page<ProductDTO> getAllProducts(Pageable pageable, ProductFilterForm form) {
        Page<Product> productPage = productService.getAllProducts(pageable, form);
        List<ProductDTO> products = modelMapper.map(productPage.getContent(), new TypeToken<List<ProductDTO>>(){}.getType());
        return new PageImpl<>(products, pageable, productPage.getTotalElements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return ResponseEntity
                .ok(productDTO);
    }

    @GetMapping("/categories/{categoryId}")
    public Page<ProductDTO> getProductByCategoryId(Pageable pageable, @PathVariable(name = "categoryId") int categoryId) {
        return productService.getProductByCategoryId(pageable, categoryId);
    }

    @GetMapping("/categoriesByName/{categoryName}")
    public Page<ProductDTO> getproductByCategoryName(Pageable pageable, @PathVariable(name = "categoryName") String name) {
        return productService.getProductByCategoryName(pageable, name);
    }

    @GetMapping("/brand/{brandId}")
    public Page<ProductDTO> getProductByBrandId(Pageable pageable, @PathVariable(name = "brandId") int brandId) {
        return productService.getProductByBrand(pageable, brandId);
    }

    @PostMapping
    public ResponseEntity<?> createNewProduct(@RequestBody CreateProductForm createProductForm) {
        Product product = productService.createNewProduct(createProductForm);
        return ResponseEntity
                .ok(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProductById(
            @PathVariable int id,
            @RequestBody UpdateProductForm updateProductForm) {
        Product product = productService.updateProductById(id, updateProductForm);
        return ResponseEntity
                .ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity
                .ok("Product deleted successfully.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProducts(@RequestParam("ids") List<Integer> productIds) {
        productService.deleteProducts(productIds);
        return ResponseEntity
                .ok("Products deleted successfully.");
    }
}
