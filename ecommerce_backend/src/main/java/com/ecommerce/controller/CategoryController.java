package com.ecommerce.controller;

import com.ecommerce.DTO.CategoryDTO;
import com.ecommerce.form.CreateCategoryForm;
import com.ecommerce.form.UpdateCategoryForm;
import com.ecommerce.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private final ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategory(Pageable pageable) {
        Page<CategoryDTO> categoryPage = categoryService.getAllCategory(pageable);
        return ResponseEntity
                .ok()
                .body(categoryPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        CategoryDTO category = categoryService.getCategoryById(id);
        return ResponseEntity
                .ok()
                .body(category);
    }

    @PostMapping
    public ResponseEntity<?> createNewCategory(@RequestBody CreateCategoryForm createCategoryForm) {
        CategoryDTO category = categoryService.createNewCategory(createCategoryForm);
        return ResponseEntity
                .ok()
                .body(category);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategoryById(
            @PathVariable int id,
            @RequestBody UpdateCategoryForm updateCategoryForm
            )
    {
        CategoryDTO category = categoryService.updateCategoryById(id, updateCategoryForm);
        return ResponseEntity
                .ok()
                .body(category);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity
                .ok()
                .body("Category deleted successfully.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCategories(@RequestParam("ids") List<Integer> categoryIds) {
        categoryService.deleteCategories(categoryIds);
        return ResponseEntity
                .ok()
                .body("Categories deleted successfully.");
    }
}
