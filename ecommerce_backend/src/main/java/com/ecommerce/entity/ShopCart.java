package com.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shop_cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="total")
    private int total;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "id")
    private ProductOption productOption;

    public ShopCart(Account account, ProductOption productOption, int total) {
        this.account = account;
        this.productOption = productOption;
        this.total = total;
    }
}