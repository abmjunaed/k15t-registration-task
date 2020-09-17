package com.k15t.pat.server.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.k15t.pat.server.entity.Address;
import com.k15t.pat.server.entity.User;

@DataJpaTest
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	void emptyDB() {
		assertEquals(0, userRepository.findAll().size());
	}

	@Test
	void saveNewUser() {
		userRepository.save(getDummyUser());
		assertEquals(1, userRepository.findAll().size());
		assertNotNull(userRepository.findByEmail(getDummyUser().getEmail()));
	}

	private User getDummyUser() {
		User user = new User();
		user.setFirstName("First name");
		user.setLastName("Last name");
		user.setPassword("Password");
		user.setEmail("a@b.com");
		Address userAddress = new Address();
		userAddress.setStreet("street");
		userAddress.setHouseNumber("houseNumber");
		userAddress.setZip("zip");
		userAddress.setCity("area");
		userAddress.setCountry("DE");
		user.setAddress(userAddress);
		return user;
	}
}
