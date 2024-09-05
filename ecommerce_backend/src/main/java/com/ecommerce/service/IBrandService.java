package com.ecommerce.service;

import com.ecommerce.entity.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBrandService {
    List<Brand> getAllBrands();
    Brand getBrandById(int id);
    Brand updateBrand(int id, Brand brand);
    Brand createBrand(Brand brand);
    void deleteBrand(int id);
}
