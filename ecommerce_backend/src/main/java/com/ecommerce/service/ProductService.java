package com.ecommerce.service;

import com.ecommerce.DTO.ProductDTO;
import com.ecommerce.Specification.ProductSpecification;
import com.ecommerce.entity.*;

import com.ecommerce.form.CreateProductForm;
import com.ecommerce.form.CreateProductOptionForm;
import com.ecommerce.form.ProductFilterForm;
import com.ecommerce.form.UpdateProductForm;
import com.ecommerce.repository.IBrandRepository;
import com.ecommerce.repository.ICategoryRepository;
import com.ecommerce.repository.IProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{
    private final ModelMapper modelMapper;
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
    private final IBrandRepository brandRepository;
    private final String FOLDER_SAVED_IMG = "../resources/images/";

    @Autowired
    public ProductService(ModelMapper modelMapper, IProductRepository productRepository, ICategoryRepository categoryRepository, IBrandRepository brandRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }
    @Override
    public Page<Product> getAllProducts(Pageable pageable, ProductFilterForm form) {
        Specification bWhere = ProductSpecification.buildWhere(form);
        Page<Product> productPage = productRepository.findAll(bWhere, pageable);
        if(productPage.isEmpty()) {
            throw new EmptyResultDataAccessException("Product not found", 1);
        }
        return productPage;
    }

    @Override
    public Page<ProductDTO> getProductByCategoryId(Pageable pageable, int categoryId) {
        Page<Product> products = productRepository.findAll(pageable);
        List<Product> products1 = products.stream()
                .filter(product -> product.getCategory().getId() == categoryId)
                .collect(Collectors.toList());
        List<ProductDTO> productDTOS = modelMapper.map(products1, new TypeToken<List<ProductDTO>>(){}.getType());
        return new PageImpl<>(productDTOS, pageable, products.getTotalElements());
    }

    @Override
    public Page<ProductDTO> getProductByBrand(Pageable pageable, int brandId) {
        Page<Product> products = productRepository.findAll(pageable);
        List<Product> products1 = products.stream()
                .filter(product -> product.getCategory().getId() == brandId)
                .collect(Collectors.toList());
        List<ProductDTO> productDTOS = modelMapper.map(products1, new TypeToken<List<ProductDTO>>(){}.getType());
        return new PageImpl<>(productDTOS, pageable, products.getTotalElements());
    }

    @Override
    public Page<ProductDTO> getProductByCategoryName(Pageable pageable, String name) {
        Page<Product> products = productRepository.findAll(pageable);
        List<Product> products1 = products.stream()
                .filter(product -> product.getCategory().getName().equals(name))
                .collect(Collectors.toList());
        List<ProductDTO> productDTOS = modelMapper.map(products1, new TypeToken<List<ProductDTO>>(){}.getType());
        return new PageImpl<>(productDTOS, pageable, products.getTotalElements());
    }


    //../resources/images/anh1.jpg
    @Override
    public Product getProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID: " + id +  " not found."));
        return product;
    }

    @Override
    @Transactional
    public Product createNewProduct(CreateProductForm createProductForm) {
        Brand brand = brandRepository.findById(createProductForm.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        Category category = categoryRepository.findById(createProductForm.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = new Product();
        product.setProductName(createProductForm.getName());
        product.setBrand(brand);
        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    @Transactional
    public Product updateProductById(int id, UpdateProductForm updateProductForm) {
        //found existing product
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found."));
        Brand brand = brandRepository.findById(updateProductForm.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        Category category = categoryRepository.findById(updateProductForm.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));


        existingProduct.setBrand(brand);
        existingProduct.setCategory(category);
        existingProduct.setProductName(updateProductForm.getName());

        Product updatedProduct = productRepository.save(existingProduct);

        return updatedProduct;
    }

    @Override
    @Transactional
    public void deleteProductById(int id) {
        try {
            Product existingProduct = productRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Product with ID: " + id + "not found."));
            productRepository.delete(existingProduct);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error deleting product with ID: " + id, ex);
        }
    }

    @Override
    @Transactional
    public void deleteProducts(List<Integer> productIds) {
        try {
            productIds.forEach(id -> deleteProductById(id));
        } catch (Exception ex) {
            throw new RuntimeException("Internal server errors.", ex);
        }
    }
}
