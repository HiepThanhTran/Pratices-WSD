package com.fh.repository;

import com.fh.pojo.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {

    List<Product> getProducts(Map<String, String> params);

    Product getProductById(int id);

    void addOrUpdate(Product product);
}
