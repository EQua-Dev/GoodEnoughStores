package com.awesomenessstudios.goodenoughstores.services.category;

import com.awesomenessstudios.goodenoughstores.models.Category;
import com.awesomenessstudios.goodenoughstores.requests.CategoryUpdateRequest;

import java.util.List;

public interface ICategoryService {

    Category getCategoryById(Long categoryId);
    Category getCategoryByName(String categoryName);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(CategoryUpdateRequest category, Long categoryId);
    void deleteCategoryById(Long categoryId);
}
