package com.ecommerce.repository;

import com.ecommerce.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    public Account findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    public Account findByEmail(String email);
}
