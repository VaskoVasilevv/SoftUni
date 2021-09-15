package com.example.xml;

import com.example.xml.model.dto.*;
import com.example.xml.service.CategoryService;
import com.example.xml.service.ProductService;
import com.example.xml.service.UserService;
import com.example.xml.util.XmlParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    //    TODO Check file path !!!!!!!
    private static final String RESOURCE_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\XML\\src\\main\\resources\\files\\";
    private static final String OUTPUT_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\XML\\src\\main\\resources\\files\\out\\";
    private static final String CATEGORY_FILE_NAME = "categories.xml";
    private static final String USER_FILE_NAME = "users.xml";
    private static final String PRODUCT_FILE_NAME = "products.xml";
    private static final String PRODUCT_IN_RANGE_FILE_NAME= "products-in-range.xml";
    private static final String SOLD_PRODUCTS= "sold-products.xml";


    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;

    public CommandLineRunner(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Select exercise :");
        int exNumber = Integer.parseInt(bufferedReader.readLine());

        switch (exNumber){

            case 1 -> productsInRange();
            case 2 -> successfullySoldProducts();
            case 3 -> categoriesByProductsCount();
        }

    }

    private void categoriesByProductsCount() {
        CategoriesViewRootDto categoriesByproducts = categoryService.findCategoriesByproducts();
            System.out.println();
    }

    private void successfullySoldProducts() throws JAXBException {
        UsersViewRootDto usersViewRootDto =
                userService.findUsersWithMoreThanOneProduct();

        xmlParser.toFile(OUTPUT_FILE_PATH + SOLD_PRODUCTS , usersViewRootDto);
    }

    private void productsInRange() throws JAXBException {
        ProductVewRootDto rootDto = productService.findProductInRangeWithoutBuyer();

        xmlParser.toFile(OUTPUT_FILE_PATH + PRODUCT_IN_RANGE_FILE_NAME,rootDto);

    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (categoryService.getEntityCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = xmlParser.fromFile(RESOURCE_FILE_PATH + CATEGORY_FILE_NAME,
                    CategorySeedRootDto.class);
            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (userService.getCount() == 0){
            UserSeedRootDto userSeedRootDto = xmlParser
                    .fromFile(RESOURCE_FILE_PATH + USER_FILE_NAME ,
                            UserSeedRootDto.class);
            userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (productService.getCount()== 0){
            ProductSeedRootDto productSeedRootDto = xmlParser
                    .fromFile(RESOURCE_FILE_PATH + PRODUCT_FILE_NAME,
                            ProductSeedRootDto.class);

            productService.seedProducts(productSeedRootDto.getProducts());
        }



    }
}
