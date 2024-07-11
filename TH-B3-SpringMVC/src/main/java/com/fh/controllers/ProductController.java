/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fh.controllers;

import com.fh.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author devlin
 */
@Controller
public class ProductController {

    @GetMapping("/products")
    public String create(Model model) {
        model.addAttribute("product", new Product());

        return "products";
    }
}
