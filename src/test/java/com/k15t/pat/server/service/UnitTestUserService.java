package com.k15t.pat.server.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.k15t.pat.common.data.UserData;
import com.k15t.pat.server.entity.User;
import com.k15t.pat.server.exception.EmailAlreadyExistsException;
import com.k15t.pat.server.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UnitTestUserService {
	@Mock
	private UserRepository userRepository;
	@Mock
	PasswordEncoder passwordEncoder;
	@InjectMocks
	private UserService userService;

	@Test
	void register() throws EmailAlreadyExistsException {
		UserData userData = getCorrectUserData();
		when(userRepository.save(isA(User.class))).then(returnsFirstArg());
		User registeredUser = userService.register(userData);
		assertTrue(registeredUser.getEmail().equals(userData.getEmail()));
	}

	@Test
	void duplicateEmailTest() throws EmailAlreadyExistsException {
		UserData userData = getCorrectUserData();
		when(userRepository.findByEmail(userData.getEmail())).thenReturn(new User());
		assertThrows(EmailAlreadyExistsException.class, () -> userService.register(userData));
		verify(userRepository, never()).save(isA(User.class));
	}

	private UserData getCorrectUserData() {
		UserData userData = new UserData();
		userData.setFirstName("First name");
		userData.setLastName("Last name");
		userData.setPassword("Password");
		userData.setMatchingPassword("Password");
		userData.setStreet("street");
		userData.setHouseNumber("houseNumber");
		userData.setZip("zip");
		userData.setCity("city");
		userData.setCountry("DE");
		userData.setEmail("a@b.com");
		return userData;
	}
}
