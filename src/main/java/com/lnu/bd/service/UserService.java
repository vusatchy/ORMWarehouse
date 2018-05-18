package com.lnu.bd.service;

import com.lnu.bd.authentication.AuthenticationResult;
import com.lnu.bd.model.User;

public interface UserService {

    //login
    User findUser(String name, String password);

    //register
    AuthenticationResult saveUser(User user);
}
