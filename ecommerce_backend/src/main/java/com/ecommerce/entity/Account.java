package com.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username", unique = true, length = 50, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname", length = 50 ,nullable = false)
    private String fullname;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GENDER gender;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @Column(name = "address", length = 150)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ROLE role;

    @OneToMany(mappedBy = "account")
    private List<ShopCart> shopCarts;

    public enum GENDER {
        Male, Female, Other
    }

    public enum ROLE {
        User, Admin
    }
}