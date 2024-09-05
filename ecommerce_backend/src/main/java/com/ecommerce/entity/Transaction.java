//package com.ecommerce.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "transaction")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class Transaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int TransactionId;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "create_date")
//    private Date createDate;
//
//    @ManyToOne
//    @JoinColumn(name = "account_id", referencedColumnName = "id")
//    private Account account;
//
//    @ManyToOne
//    @JoinColumn(name = "option_id", referencedColumnName = "id")
//    private ProductOption productOption;
//
//    public Transaction(Account account, ProductOption productOption, Date date) {
//        this.account = account;
//        this.productOption = productOption;
//        this.createDate = date;
//    }
//}