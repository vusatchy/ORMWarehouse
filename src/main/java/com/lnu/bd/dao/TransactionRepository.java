package com.lnu.bd.dao;

import com.lnu.bd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Repository
public class TransactionRepository {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void processUserTransaction(boolean fail) throws Exception {
        User user = new User();
        user.setLogin("Hapko");
        user.setPassword("linearregression");
        user.setEmail("Hapko@gmail.com");
        user.setRegistrationTime(Date.valueOf(LocalDate.now()));
        userRepository.save(user);
        if (fail) {
            throw new Exception("Transaction exception");
        }
        user = new User();
        user.setLogin("Eiler");
        user.setPassword("qwertyuio");
        user.setEmail("Eiler@gmail.com");
        user.setRegistrationTime(Date.valueOf(LocalDate.now()));
        userRepository.save(user);
    }
}
