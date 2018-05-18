package com.lnu.bd.exceptions;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String message) {
	super(message);
    }
}
