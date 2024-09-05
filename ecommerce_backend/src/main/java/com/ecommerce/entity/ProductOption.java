package com.ecommerce.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_options")
@Data
@NoArgsConstructor
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int optionId;

    @Column(name = "color", unique = true , nullable = false)
    private String color;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "price_sale", nullable = false)
    private double priceSale;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "ram", nullable = false)
    private int ram;

    @Column(name = "image", nullable = false)
    private String image;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName ="id" )
    private Product product;

    @OneToMany(mappedBy = "productOption")
    private List<ShopCart> shopCarts;

}
