package com.eleia.storews.service;

import com.eleia.storews.model.Product;

import java.util.Collection;

public interface IProductService {

    public abstract void createProduct(Product product);

    public abstract void updateProduct(String id, Product product);

    public abstract void deleteProduct(String id);

    public abstract Collection<Product> getProducts();

    public abstract Product getProduct(String id);


}
