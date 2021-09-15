package com.example.jsonprocessing;

import com.example.jsonprocessing.constants.GlobalConstants;
import com.example.jsonprocessing.model.dto.CategoryByProductsCountDto;
import com.example.jsonprocessing.model.dto.ProductNameAndPriceDto;
import com.example.jsonprocessing.model.dto.UserSoldDto;
import com.example.jsonprocessing.service.CategoryService;
import com.example.jsonprocessing.service.ProductService;
import com.example.jsonprocessing.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final String PRODUCT_IN_RANGE_FILE_NAME = "products-in-range.json";
    private static final String USERS_AND_SOLD_PRODUCTS = "user-and-sold-products.json";
    private static final String CATEGORIES_BY_PRODUCTS = "categories-by-products.json";

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public CommandLineRunnerImpl(CategoryService categoryService, UserService userService, ProductService productService, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.gson = gson;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Enter exercise: ");

        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum){

            case 1 -> productsInRange();
            case 2 -> soldProducts();
            case 3 -> categoriesByProductCount();



        }


    }

    private void categoriesByProductCount() throws IOException {
        List<CategoryByProductsCountDto> allCategoriesByProductCount = categoryService.findAllCategoriesByProductCount();

        String content = gson.toJson(allCategoriesByProductCount);

        writeToFile(GlobalConstants.OUTPUT_PATH + CATEGORIES_BY_PRODUCTS,content);
    }


    private void soldProducts() throws IOException {
       List<UserSoldDto> userSoldDtos = userService.findAllUsersWithMoreThanOneSoldProducts();

       String content = gson.toJson(userSoldDtos);

       writeToFile(GlobalConstants.OUTPUT_PATH+ USERS_AND_SOLD_PRODUCTS, content);
    }

    private void productsInRange() throws IOException {

        List<ProductNameAndPriceDto> productDtos =
                productService.findAllProductsInRangeOrderByPrice(BigDecimal.valueOf(500L),BigDecimal.valueOf(1000L));

        String content = gson.toJson(productDtos);

        writeToFile(GlobalConstants.OUTPUT_PATH + PRODUCT_IN_RANGE_FILE_NAME,content);
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files
                .write(Path.of(filePath),
                        Collections.singleton(content));

    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUser();
        productService.seedProducts();
    }
}
