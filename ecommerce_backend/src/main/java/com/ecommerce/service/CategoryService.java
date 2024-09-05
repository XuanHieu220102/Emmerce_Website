package com.ecommerce.service;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.form.CreateCategoryForm;
import com.ecommerce.form.UpdateCategoryForm;
import com.ecommerce.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final ModelMapper modelMapper;
    private final ICategoryRepository categoryRepository;
    @Override
    public Page<CategoryDTO> getAllCategory(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        if (categoryPage.isEmpty()) {
            throw new EmptyResultDataAccessException("Category not found.", 1);
        }
        return categoryPage.map(category -> modelMapper.map(category, CategoryDTO.class));
    }

    @Override
    public CategoryDTO getCategoryById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with ID: " + id + " not found."));
        return modelMapper.map(category, CategoryDTO.class);
    }


    @Override
    @Transactional
    public CategoryDTO createNewCategory(CreateCategoryForm createCategoryForm) {
        Category newCategory = Category.builder()
                .name(createCategoryForm.getName())
                .build();
        try {
           Category resultCategory = categoryRepository.save(newCategory);
           return modelMapper.map(resultCategory, CategoryDTO.class);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException("Category already exists.", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error creating category.", ex);
        }
    }

    @Override
    @Transactional
    public CategoryDTO updateCategoryById(int id, UpdateCategoryForm updateCategoryForm) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found."));

        // Update category with new information from input form
        existingCategory.setName(updateCategoryForm.getName());

        // Save updated category to database
        try {
            Category resultCategory = categoryRepository.save(existingCategory);
            return modelMapper.map(resultCategory, CategoryDTO.class);
        } catch (Exception ex) {
            throw new RuntimeException("Error updating category.", ex);
        }
    }
    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        try {
            Category existingCategory = categoryRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Category with ID: " + id + " not found."));
            categoryRepository.delete(existingCategory);
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error deleting category with ID: " + id, ex);
        }
    }

    @Override
    @Transactional
    public void deleteCategories(List<Integer> categoryIds) {
        try {
            categoryIds.forEach(id -> deleteCategoryById(id));
        } catch (Exception ex) {
            throw new RuntimeException("Internal server errors.", ex);
        }
    }
}
