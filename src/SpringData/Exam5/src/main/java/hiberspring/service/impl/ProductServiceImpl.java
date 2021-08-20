package hiberspring.service.impl;

import hiberspring.domain.dtos.ProductSeedRootDto;
import hiberspring.domain.entities.Product;
import hiberspring.repository.ProductRepository;
import hiberspring.service.BranchService;
import hiberspring.service.ProductService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT_FILE_PATH = "D:\\SoftUniGit\\src\\SpringData\\Exam5\\src\\main\\resources\\files\\products.xml";

    private final ProductRepository productRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final BranchService branchService;

    public ProductServiceImpl(ProductRepository productRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, BranchService branchService) {
        this.productRepository = productRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.branchService = branchService;
    }

    @Override
    public Boolean productsAreImported() {
        return productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(PRODUCT_FILE_PATH));
    }

    @Override
    public String importProducts() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();


        xmlParser.fromXml(PRODUCT_FILE_PATH, ProductSeedRootDto.class).getProducts()
        .stream()
        .filter(productSeedDto -> {

            boolean isValid = validationUtil.isValid(productSeedDto);

            sb.append(isValid ? String.format("Successfully imported Product %s.",productSeedDto.getBranch())
                    :"Invalid Branch").append(System.lineSeparator());

            return isValid;
        }).map(productSeedDto -> {
            Product product = modelMapper.map(productSeedDto, Product.class);

            product.setBranch(branchService.getBranchByName(productSeedDto.getBranch()));

            return product;

        }).forEach(productRepository::save);


        return sb.toString();
    }
}
