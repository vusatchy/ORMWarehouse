package com.lnu.bd.impl;

import com.lnu.bd.authentication.*;
import com.lnu.bd.dao.UserRepository;
import com.lnu.bd.exceptions.InvalidEmailException;
import com.lnu.bd.exceptions.InvalidPasswordException;
import com.lnu.bd.exceptions.UserAlreadyExistException;
import com.lnu.bd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lnu.bd.service.UserService;
import com.lnu.bd.util.EncryptionUtil;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    //login
    @Override
    public User findUser(String name, String password) {
	User user = userRepository.findByLogin(name);
	if (user == null) {
	    return null;
	}
	if (user.getPassword().equals(EncryptionUtil.encrypt(password))) {
	    return user;
	} else {
	    return null;
	}
    }



    //register
   @Override
    public AuthenticationResult saveUser(User user) {
	   AuthenticationChain authenticationChain = new NameExistAuthentication(userRepository);
	   authenticationChain.linkWith(new ValidEmailAuthentication()).linkWith(
			   new ValidPasswordAuthentication());
	   try {
		   authenticationChain.check(user);
	   } catch (InvalidPasswordException e) {
		   return AuthenticationResult.INVALID_PASSWORD;
	   } catch (InvalidEmailException e) {
		   return AuthenticationResult.INVALID_EMAIL;
	   } catch (UserAlreadyExistException e) {
		   return AuthenticationResult.INVALID_NAME;
	   }
	   user.setPassword(EncryptionUtil.encrypt(user.getPassword()));
	   userRepository.save(user);
	   return AuthenticationResult.SUCCESS;
   }
    
}
