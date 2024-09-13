package com.awesomenessstudios.goodenoughstores.services.category;

import com.awesomenessstudios.goodenoughstores.exceptions.AlreadyExistsException;
import com.awesomenessstudios.goodenoughstores.exceptions.ProductNotFoundException;
import com.awesomenessstudios.goodenoughstores.exceptions.ResourceNotFoundException;
import com.awesomenessstudios.goodenoughstores.models.Category;
import com.awesomenessstudios.goodenoughstores.models.Product;
import com.awesomenessstudios.goodenoughstores.repositories.CategoryRepository;
import com.awesomenessstudios.goodenoughstores.requests.AddCategoryRequest;
import com.awesomenessstudios.goodenoughstores.requests.AddProductRequest;
import com.awesomenessstudios.goodenoughstores.requests.CategoryUpdateRequest;
import com.awesomenessstudios.goodenoughstores.requests.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long categoryId) {

        return categoryRepository.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Category Not Found!"));
    }

    @Override
    public Category getCategoryByName(String categoryName) {

        return categoryRepository.findByName(categoryName);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(c -> !categoryRepository.existsByName(c.getName()))
                .map(categoryRepository :: save)
                .orElseThrow(() -> new AlreadyExistsException(category.getName() + "already exists!"));

    }

    private Category addCategory(AddCategoryRequest request) {
        return new Category(
                request.getName()
        );
    }

    @Override
    public Category updateCategory(CategoryUpdateRequest category, Long categoryId) {
        return Optional.ofNullable(getCategoryById(categoryId
                ))
                .map(existingCategory -> updateExistingCategory(existingCategory, category))
                .map(categoryRepository::save)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found!"));
    }

    private Category updateExistingCategory(Category existingCategory, CategoryUpdateRequest request) {
        existingCategory.setName(request.getName());

        return existingCategory;
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.findById(categoryId).ifPresentOrElse(categoryRepository::delete, () -> {
            throw new ResourceNotFoundException("Category Not Found!");
        });
    }
}
