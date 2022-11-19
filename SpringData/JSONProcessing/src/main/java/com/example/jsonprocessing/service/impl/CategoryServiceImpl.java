package com.example.jsonprocessing.service.impl;

import com.example.jsonprocessing.model.dto.CategoryByProductsCountDto;
import com.example.jsonprocessing.model.dto.CategorySeedDto;
import com.example.jsonprocessing.model.entity.Category;
import com.example.jsonprocessing.model.entity.Product;
import com.example.jsonprocessing.repository.CategoryRepository;
import com.example.jsonprocessing.service.CategoryService;
import com.example.jsonprocessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonprocessing.constants.GlobalConstants.RESOURCES_FILE_PATH;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private static final String CATEGORIES_FILE_NAME = "categories.json";
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0){
            return;
        }
        String fileContent = Files.readString(Path.of(RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME));

        CategorySeedDto[] categorySeedDto = gson
                .fromJson(fileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDto)
                .filter(validationUtil::isValid)
                .map(categorySeedDtos -> modelMapper.map(categorySeedDtos, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categorySet = new HashSet<>();
        int catCount= ThreadLocalRandom
                .current().nextInt(1,3);
        long totalCategoriesCount = categoryRepository.count();

        for (int i = 0; i < catCount; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1,totalCategoriesCount +1);

            categorySet.add(categoryRepository.findById(randomId).orElse(null));

        }
        return categorySet;
    }

    @Override
    public List<CategoryByProductsCountDto> findAllCategoriesByProductCount() {
        List<Category> categories = categoryRepository.getCategoryByProductsCount();

        return categories.stream()
                .map(category -> {
                    CategoryByProductsCountDto categoryByProductsDto = modelMapper.map(category, CategoryByProductsCountDto.class);
                    setFields(category,categoryByProductsDto);
                    return categoryByProductsDto;
                }).collect(Collectors.toList());
    }

    private void setFields(Category category, CategoryByProductsCountDto categoryByProductsDto) {

        int count = category.getProducts().size();
        BigDecimal averagePrice = BigDecimal.ZERO;
        BigDecimal totalRevenue = category.getProducts().stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        if (count>0){
            averagePrice = totalRevenue.divide(BigDecimal.valueOf(count), RoundingMode.FLOOR);}
        categoryByProductsDto.setProductsCount(count);
        categoryByProductsDto.setTotalRevenue(totalRevenue);
        categoryByProductsDto.setAveragePrice(averagePrice);
    }

}
