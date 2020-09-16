package com.k15t.pat.server.service;

import com.k15t.pat.common.data.UserData;
import com.k15t.pat.server.entity.User;
import com.k15t.pat.server.exception.EmailAlreadyExistsException;

public interface IUserService {
	User register(final UserData user) throws EmailAlreadyExistsException;

//	boolean checkIfUserExist(final String email);
//
//	void sendRegistrationConfirmationEmail(final User user);
//
//	boolean verifyUser(final String token) throws InvalidTokenException;
}
