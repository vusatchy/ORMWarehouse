package com.lnu.bd.dao;

import com.lnu.bd.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT sum_function(?1)", nativeQuery = true)
    double sumFunction(int id);

    List<User> findByLoginStartsWith(String prefix);

    User findByLogin(String login);

    boolean existsByLogin(String email);
}

