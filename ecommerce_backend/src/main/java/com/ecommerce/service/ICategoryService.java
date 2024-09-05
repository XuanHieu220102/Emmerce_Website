package com.ecommerce.service;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.form.CreateCategoryForm;
import com.ecommerce.form.UpdateCategoryForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    Page<CategoryDTO> getAllCategory(Pageable pageable);

    CategoryDTO getCategoryById(int id);

    CategoryDTO createNewCategory(CreateCategoryForm createCategoryForm);

    CategoryDTO updateCategoryById(int id, UpdateCategoryForm updateCategoryForm);

    void deleteCategories(List<Integer> categoryIds);

    void deleteCategoryById(int id);
}
