package com.ecommerce.service;


import com.ecommerce.DTO.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.form.CreateProductForm;
import com.ecommerce.form.ProductFilterForm;
import com.ecommerce.form.UpdateProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IProductService {
    Page<Product> getAllProducts(Pageable pageable, ProductFilterForm form);
    Page<ProductDTO> getProductByCategoryId(Pageable pageable, int categoryId);
    Page<ProductDTO> getProductByBrand(Pageable pageable, int brandId);
    Page<ProductDTO> getProductByCategoryName(Pageable pageable, String name);
    Product createNewProduct(CreateProductForm createProductForm);
    Product updateProductById(int productId, UpdateProductForm updateProductForm);
    void deleteProductById(int productId);
    Product getProductById(int id);
    void deleteProducts(List<Integer> productIds);
}
