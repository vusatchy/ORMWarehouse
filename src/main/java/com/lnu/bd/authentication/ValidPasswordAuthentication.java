package com.lnu.bd.authentication;


import com.lnu.bd.exceptions.InvalidEmailException;
import com.lnu.bd.exceptions.InvalidPasswordException;
import com.lnu.bd.exceptions.UserAlreadyExistException;
import com.lnu.bd.model.User;

import java.util.regex.Pattern;

public class ValidPasswordAuthentication extends AuthenticationChain {

    private final static Pattern passwordPattern = Pattern
	.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$");

    @Override
    public void check(User user) throws InvalidPasswordException, InvalidEmailException, UserAlreadyExistException {
	if (!passwordPattern.matcher(user.getPassword()).matches()) {
	    throw new InvalidPasswordException("Invalid password");
	}
	 checkNext(user);
    }
}
