package com.ecommerce.repository;

import com.ecommerce.entity.Account;
import com.ecommerce.entity.ProductOption;
import com.ecommerce.entity.ShopCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopCartRepository extends JpaRepository<ShopCart, Integer> {
    List<ShopCart> findByAccountId(int accountId);
    Optional<ShopCart> findByAccountAndProductOption(Account account, ProductOption productOption);
}
