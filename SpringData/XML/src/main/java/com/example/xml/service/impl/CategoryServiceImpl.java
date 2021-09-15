package com.example.xml.service.impl;

import com.example.xml.model.dto.CategoriesViewRootDto;
import com.example.xml.model.dto.CategorySeedDto;
import com.example.xml.model.dto.CategoryViewNameDto;
import com.example.xml.model.entity.Category;
import com.example.xml.model.entity.Product;
import com.example.xml.reposirtory.CategoryRepository;
import com.example.xml.service.CategoryService;
import com.example.xml.util.ValidationUtil;
import com.example.xml.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidationUtil validationUtil, XmlParser xmlParser) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        categories.stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public long getEntityCount() {
        return categoryRepository.count();
    }

    @Override
    public Set<Category> getRandomCategories() {

        Set<Category> categories = new HashSet<>();
        long categoriesCount = categoryRepository.count();
        for (int i = 0; i < 2; i++) {
            long randomId = ThreadLocalRandom
                    .current().nextLong(1, categoriesCount + 1);
            categories.add(categoryRepository.findById(randomId)
                    .orElse(null));
        }


        return categories;
    }

    @Override
    public CategoriesViewRootDto findCategoriesByproducts() {
        CategoriesViewRootDto categoriesViewRootDto = new CategoriesViewRootDto();
        BigDecimal avgPrice = BigDecimal.ZERO;
        AtomicReference<BigDecimal> totalRevenue = new AtomicReference<>(BigDecimal.ZERO);


        categoriesViewRootDto.setCategories(categoryRepository
                .findAllCategoriesByProductsCount()
                .stream().map(category -> {
                    CategoryViewNameDto categoryViewNameDto = modelMapper.map(category, CategoryViewNameDto.class);

                    int size = category.getProducts().size();
                    categoryViewNameDto.setProductsCount(size);


                    for (Product product : category.getProducts()) {
                        avgPrice.add(product.getPrice());
                    }
                    categoryViewNameDto.setAveragePrice(avgPrice);

                    totalRevenue.set(avgPrice.multiply(BigDecimal.valueOf(size)));

                    categoryViewNameDto.setTotalRevenue(totalRevenue.get());

                    return categoryViewNameDto;
                }).collect(Collectors.toList()));

        return categoriesViewRootDto;
    }
}
