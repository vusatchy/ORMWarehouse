package com.lnu.bd.dao;

import com.lnu.bd.model.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase,Integer> {

    Iterable<Purchase> findAllByUserId(int userId);
}
