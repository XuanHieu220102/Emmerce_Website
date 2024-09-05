package com.ecommerce.service;

import com.ecommerce.entity.Brand;
import com.ecommerce.repository.IBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BrandService implements IBrandService{
    @Autowired
    private IBrandRepository brandRepository;
    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(int id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No such brand by id: " + id));
    }

    @Override
    @Transactional
    public Brand updateBrand(int id, Brand brand) {
        Brand existingBrand = getBrandById(id);
        existingBrand.setName(brand.getName());

        return brandRepository.save(existingBrand);
    }

    @Override
    @Transactional
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(int id) {
        Brand existingBrand = getBrandById(id);
        brandRepository.delete(existingBrand);
    }
}
