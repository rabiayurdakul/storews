package com.eleia.storews.service;

import com.eleia.storews.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService{

    public static Map<String,Product> productRepo = new HashMap<>();


    static {

        Product glass = new Product();
        glass.setId("1");
        glass.setName("Glass");
        glass.setPrice(10.0);
        productRepo.put(glass.getId(),glass);

        Product spoon = new Product();
        spoon.setId("2");
        spoon.setName("Spon");
        spoon.setPrice(12.99);
        productRepo.put(spoon.getId(), spoon);
    }

    @Override
    public void createProduct(Product product) {
        productRepo.put(product.getId(),product);
    }

    @Override
    public void updateProduct(String id, Product product) {

        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);

    }

    @Override
    public void deleteProduct(String id) {
        productRepo.remove(id);

    }

    @Override
    public Collection<Product> getProducts() {
        return productRepo.values();
    }

    @Override
    public Product getProduct(String id) {
        return productRepo.get(id);
    }
}
