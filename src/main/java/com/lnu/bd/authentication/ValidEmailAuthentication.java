package com.lnu.bd.authentication;


import com.lnu.bd.exceptions.InvalidEmailException;
import com.lnu.bd.exceptions.InvalidPasswordException;
import com.lnu.bd.exceptions.UserAlreadyExistException;
import com.lnu.bd.model.User;

import java.util.regex.Pattern;

public class ValidEmailAuthentication extends AuthenticationChain {

    private final static Pattern emailPattern = Pattern
            .compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    @Override
    public void check(User user) throws InvalidEmailException, InvalidPasswordException, UserAlreadyExistException {
        if (!emailPattern.matcher(user.getEmail()).matches()) {
            throw new InvalidEmailException("Invalid e-mail");
        }
        checkNext(user);
    }
}
