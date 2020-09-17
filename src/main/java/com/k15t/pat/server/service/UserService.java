package com.k15t.pat.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.k15t.pat.server.entity.User;
import com.k15t.pat.server.exception.EmailAlreadyExistsException;
import com.k15t.pat.server.model.UserDTO;
import com.k15t.pat.server.repository.UserRepository;

@Service
public class UserService implements IUserService {
	Logger log = LoggerFactory.getLogger(getClass());
	private UserRepository userRepository;
	PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User register(UserDTO userData) throws EmailAlreadyExistsException {
		log.debug("in register service");
		if (checkIfUserExist(userData.getEmail())) {
			throw new EmailAlreadyExistsException("User already exists for this email");
		}
		User userEntity = new User();
		BeanUtils.copyProperties(userData, userEntity);
		encodePassword(userEntity, userData);
		log.debug("saving user");
		return userRepository.save(userEntity);
	}

	private boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) != null ? true : false;
	}

	private void encodePassword(User userEntity, UserDTO user) {
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
	}
}
