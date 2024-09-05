package com.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

//    @CreatedBy
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "create_by", referencedColumnName = "id")
//    private Account createBy;
//
//    @CreatedDate
//    @Column(name = "create_at", nullable = false, updatable = false)
//    private LocalDateTime createAt;
//
//    @LastModifiedBy
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "last_modified_by", referencedColumnName = "id", insertable = false)
//    private Account lastModifiedBy;
//
//    @LastModifiedDate
//    @Column(name = "last_modified_at", insertable = false)
//    private LocalDateTime lastModifiedAt;
}
