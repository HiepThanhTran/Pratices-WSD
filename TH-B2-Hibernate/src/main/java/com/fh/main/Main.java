package com.fh.main;

import com.fh.repository.implement.CategoryRepositoryImplement;
import com.fh.repository.implement.ProductRepositoryImplement;
import com.fh.repository.implement.StatsRepositoryImplement;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CategoryRepositoryImplement categoryRepositoryImplement = new CategoryRepositoryImplement();
        categoryRepositoryImplement.getCategories().forEach(c -> System.out.println(c.getName()));

        System.out.println("==========");

        Map<String, String> params = new HashMap<>();
//        params.put("name", "iPhone");
        params.put("page", "1");
        ProductRepositoryImplement productRepositoryImplement = new ProductRepositoryImplement();
        productRepositoryImplement.getProducts(params).forEach(p -> System.out.printf("%s - %d\n", p.getName(), p.getPrice()));

        System.out.println("==========");

        StatsRepositoryImplement statsRepositoryImplement = new StatsRepositoryImplement();
        statsRepositoryImplement.statsRevenueByProduct().forEach(o -> System.out.printf("%s - %s: %d VND\n", o[0], o[1], o[2]));
    }
}
