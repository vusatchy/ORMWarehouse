package com.lnu.bd.util;

import com.lnu.bd.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperUtil {

    public static User userMapper(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setRegistrationTime(rs.getDate("registration_time"));
        return user;
    }

    public static Category categoryMapper(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setName(rs.getString("name"));
        return category;
    }

    public static Product productMapper(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getFloat("price"));
        product.setAvaliable(rs.getBoolean("is_avaliable"));
        Category category = new Category();
        category.setId(rs.getInt("category_id"));
        category.setName(rs.getString("cname"));
        product.setCategory(category);
        return product;
    }

    public static Feedback feedbackMapper(ResultSet rs, int rowNum) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setId(rs.getInt("id"));
        feedback.setDate(rs.getDate("time"));
        feedback.setComment(rs.getString("comment"));
        User user = userMapper(rs, rowNum);
        user.setId(rs.getInt("user_id"));
        feedback.setUser(user);
        Product product = productMapper(rs, rowNum);
        product.setId(rs.getInt("product_id"));
        Category category = new Category();
        category.setId(rs.getInt("category_id"));
        category.setName(rs.getString("cname"));
        product.setCategory(category);
        feedback.setProduct(product);
        return feedback;
    }

    public static Purchase purchaseMapper(ResultSet rs, int rowNum) throws SQLException {
        Purchase purchase = new Purchase();
        purchase.setId(rs.getInt("id"));
        purchase.setTime(rs.getDate("time"));
        User user = userMapper(rs, rowNum);
        user.setId(rs.getInt("user_id"));
        purchase.setUser(user);
        Product product = productMapper(rs, rowNum);
        product.setId(rs.getInt("product_id"));
        Category category = new Category();
        category.setId(rs.getInt("category_id"));
        category.setName(rs.getString("cname"));
        product.setCategory(category);
        purchase.setProduct(product);
        return purchase;
    }
}
