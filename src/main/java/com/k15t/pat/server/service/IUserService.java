package com.k15t.pat.server.service;

import com.k15t.pat.server.entity.User;
import com.k15t.pat.server.exception.EmailAlreadyExistsException;
import com.k15t.pat.server.model.UserDTO;

public interface IUserService {
	User register(final UserDTO user) throws EmailAlreadyExistsException;
}
