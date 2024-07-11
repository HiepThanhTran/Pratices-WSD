package com.fh.services;

import com.fh.utils.JDBC;
import com.fh.pojo.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryServices {

    public List<Category> getCates() throws SQLException {
        List<Category> cates = new ArrayList<>();
        try ( Connection conn = JDBC.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * From Category");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category c = new Category(id, name);
                cates.add(c);
            }
        }

        return cates;
    }
}
