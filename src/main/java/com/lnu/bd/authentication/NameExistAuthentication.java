package com.lnu.bd.authentication;


import com.lnu.bd.dao.UserRepository;
import com.lnu.bd.exceptions.InvalidEmailException;
import com.lnu.bd.exceptions.InvalidPasswordException;
import com.lnu.bd.exceptions.UserAlreadyExistException;
import com.lnu.bd.model.User;

import java.text.MessageFormat;

public class NameExistAuthentication extends AuthenticationChain {

    private UserRepository userRepository;

    public NameExistAuthentication(UserRepository userRepository) {
	this.userRepository = userRepository;
    }

    @Override
    public void check(User user) throws UserAlreadyExistException, InvalidEmailException, InvalidPasswordException {
	if (userRepository.existsByLogin(   user.getEmail())) {
	    throw new UserAlreadyExistException(MessageFormat.format("User with name {0} already exit",
		user.getLogin()));
	}
	checkNext(user);
    }
}
