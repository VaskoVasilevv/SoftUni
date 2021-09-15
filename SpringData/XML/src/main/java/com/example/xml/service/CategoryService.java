package com.example.xml.service;

import com.example.xml.model.dto.CategoriesViewRootDto;
import com.example.xml.model.dto.CategorySeedDto;
import com.example.xml.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDto> categories);

    long getEntityCount();

    Set<Category> getRandomCategories();

    CategoriesViewRootDto findCategoriesByproducts();
}
