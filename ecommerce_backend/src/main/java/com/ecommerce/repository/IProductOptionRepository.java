package com.ecommerce.repository;

import com.ecommerce.entity.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IProductOptionRepository extends JpaRepository<ProductOption, Integer> {
    List<ProductOption> findAllByProductId(int productId);
    void deleteByProductId(int productId);
}
