/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fh.service;

import com.fh.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author devlin
 */
public interface ProductService {
    List<Product> getProducts(Map<String, String> params);
    
    Product getProductById(int id);
    
    void addOrUpdate(Product p);
}
