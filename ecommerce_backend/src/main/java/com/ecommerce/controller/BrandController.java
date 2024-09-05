package com.ecommerce.controller;

import com.ecommerce.DTO.BrandDTO;
import com.ecommerce.entity.Brand;
import com.ecommerce.form.CreateBrandForm;
import com.ecommerce.form.UpdateBrandForm;
import com.ecommerce.service.IBrandService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
@CrossOrigin("*")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    ResponseEntity<?> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        List<BrandDTO> brandDTOS = modelMapper.map(brands, new TypeToken<List<BrandDTO>>(){}.getType());
        return ResponseEntity.ok(brandDTOS);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getBrandById(@PathVariable int id) {
        Brand brand = brandService.getBrandById(id);
        BrandDTO brandDTO = modelMapper.map(brand, BrandDTO.class);
        return ResponseEntity.ok(brandDTO);
    }

    @PostMapping
    ResponseEntity<?> createBrand(@RequestBody CreateBrandForm form) {
        Brand brand = modelMapper.map(form, Brand.class);
        Brand createdBrand = brandService.createBrand(brand);
        return ResponseEntity.ok(createdBrand);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateBrand(@PathVariable int id, @RequestBody UpdateBrandForm form) {
        Brand brand = modelMapper.map(form, Brand.class);
        Brand updatedBrand = brandService.updateBrand(id, brand);
        return ResponseEntity.ok(updatedBrand);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteBrand(@PathVariable int id) {
        brandService.deleteBrand(id);
        return ResponseEntity.ok("Deleted successfully.");
    }
}
