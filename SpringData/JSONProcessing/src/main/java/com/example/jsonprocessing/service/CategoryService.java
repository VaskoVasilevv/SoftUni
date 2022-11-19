package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.dto.CategoryByProductsCountDto;
import com.example.jsonprocessing.model.entity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();


    List <CategoryByProductsCountDto> findAllCategoriesByProductCount();

}
