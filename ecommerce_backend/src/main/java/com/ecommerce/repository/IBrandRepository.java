package com.ecommerce.repository;

import com.ecommerce.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand, Integer> {
}
