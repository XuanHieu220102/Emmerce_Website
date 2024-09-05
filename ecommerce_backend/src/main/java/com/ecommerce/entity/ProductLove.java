package com.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "love_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "option_id", referencedColumnName = "id")
    private ProductOption productOption;

    public ProductLove(Account account, ProductOption productOption) {
        this.account = account;
        this.productOption = productOption;
    }
}