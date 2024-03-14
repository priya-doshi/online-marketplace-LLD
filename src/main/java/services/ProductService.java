package services;

import exceptions.ProductDoesNotExistException;
import models.Product;
import repository.ProductRepository;

import java.math.BigDecimal;

import static utils.utility.generateNextId;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, String details, BigDecimal amount) {
        Product product = Product.builder()
                .productId(generateNextId())
                .amount(amount)
                .name(name)
                .description(details)
                .build();

        return productRepository.createProduct(product);
    }

    public Product getProduct(String productId) throws ProductDoesNotExistException {
        return productRepository.getProductByProductId(productId);
    }

}
