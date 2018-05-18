package com.lnu.bd.authentication;


import com.lnu.bd.exceptions.InvalidEmailException;
import com.lnu.bd.exceptions.InvalidPasswordException;
import com.lnu.bd.exceptions.UserAlreadyExistException;
import com.lnu.bd.model.User;

public abstract class AuthenticationChain {

    private AuthenticationChain next;

    public AuthenticationChain linkWith(AuthenticationChain next) {
	this.next = next;
	return next;
    }

    public abstract void check(User user) throws UserAlreadyExistException,InvalidEmailException,InvalidPasswordException;

    protected void checkNext(User user) throws UserAlreadyExistException,InvalidEmailException,InvalidPasswordException {
	if (next == null) {
	    return;
	}
	next.check(user);
    }

}
