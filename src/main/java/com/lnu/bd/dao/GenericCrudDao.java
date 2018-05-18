package com.lnu.bd.dao;

import java.util.List;
public interface GenericCrudDao<T> {

    List<T> getAll();

    void save(T model);

    T getById(int id);

    void delete(T model);

    void update(T model);
}
