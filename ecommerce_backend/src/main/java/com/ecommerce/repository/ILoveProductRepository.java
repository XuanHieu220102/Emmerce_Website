package com.ecommerce.repository;

import com.ecommerce.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILoveProductRepository extends JpaRepository<ProductLove, Integer> {
    List<ProductLove> findByAccountId(int accountId);
    Optional<ProductLove> findByAccountAndProductOption(Account account, ProductOption productOption);

}
