package com.miapplication.productosservice.service;

import com.miapplication.productosservice.model.Product;

import java.util.List;

public interface IProductService {

    public List<Product> getProduct();

    public void saveProduct(Product p);

    public void deleteProduct(Long id);

    public Product editProduct(Long id,Product p);

    public Product findProductById(Long id);

}