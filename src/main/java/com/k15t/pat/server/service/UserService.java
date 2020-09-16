package com.k15t.pat.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.k15t.pat.common.data.UserData;
import com.k15t.pat.server.entity.User;
import com.k15t.pat.server.exception.EmailAlreadyExistsException;
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
	public User register(UserData userData) throws EmailAlreadyExistsException {
		log.debug("in register service");
		// Let's check if user already registered with us
		if (checkIfUserExist(userData.getEmail())) {
			throw new EmailAlreadyExistsException("User already exists for this email");
		}
		User userEntity = new User();
		BeanUtils.copyProperties(userData, userEntity);
		encodePassword(userEntity, userData);
		log.debug("saving user");
		return userRepository.save(userEntity);
	}

//	@Override
	private boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email) != null ? true : false;
	}

//
	private void encodePassword(User userEntity, UserData user) {
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
	}
//
//	@Override
//	public void sendRegistrationConfirmationEmail(User user) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public boolean verifyUser(String token) throws InvalidTokenException {
//		// TODO Auto-generated method stub
//		return false;
//	}
}
