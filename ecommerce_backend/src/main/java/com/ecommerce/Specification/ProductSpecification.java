package com.ecommerce.Specification;

import com.ecommerce.entity.Product;
import com.ecommerce.form.ProductFilterForm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class ProductSpecification  {

    public static Specification<Product> buildWhere(ProductFilterForm form) {
        Specification<Product> where = null;
        if (form.getFilterName() != null && !form.getFilterName().isEmpty()) {
            String name = form.getFilterName().trim();
            CustomSpecification specification = new CustomSpecification("productName", name);
            where = Specification.where(specification);
        }
        if(form.getCategory() != null && !form.getCategory().isEmpty()) {
            String category = form.getCategory().trim();
            CustomSpecification specification = new CustomSpecification("category", category);
            if(where != null) where = where.and(specification);
            else where = Specification.where(specification);
        }
        if(form.getBrand() != null && !form.getBrand().isEmpty()) {
            String brand = form.getBrand().trim();
            CustomSpecification specification = new CustomSpecification("brand", brand);
            if(where != null) where = where.and(specification);
            else where = Specification.where(specification);
        }
        return where;
    }

    @RequiredArgsConstructor
    static class CustomSpecification implements Specification<Product> {
        @NonNull
        private String field;

        @NonNull
        private String value;
        private final String PRODUCT_NAME = "productName";
        private final String CATEGORY = "category";
        private final String BRAND = "brand";

        @Override
        public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            if(field.equalsIgnoreCase(PRODUCT_NAME)) {
                return criteriaBuilder.like(root.get(PRODUCT_NAME), "%" + value.toString() + "%");
            }
            if(field.equalsIgnoreCase(BRAND)) {
                return criteriaBuilder.like(root.get(BRAND).get("name"), "%" + value.toString() + "%");
            }
            if(field.equalsIgnoreCase(CATEGORY)) {
                return criteriaBuilder.like(root.get(CATEGORY).get("name"), "%" + value.toString() + "%");
            }
            return null;
        }
    }

}