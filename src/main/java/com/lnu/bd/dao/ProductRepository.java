package com.lnu.bd.dao;

import com.lnu.bd.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
