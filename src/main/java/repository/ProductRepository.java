package repository;

import exceptions.ProductDoesNotExistException;
import models.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<String, Product> productMap = new HashMap<>();

    public Product createProduct(Product product) {
        productMap.put(product.getProductId(), product);
        return product;
    }

    public Product getProductByProductId(String productId) throws ProductDoesNotExistException {
        if (!productMap.containsKey(productId)) {
            throw new ProductDoesNotExistException("User with given productId does not exist " + productId);
        }
        return productMap.get(productId);
    }
}
