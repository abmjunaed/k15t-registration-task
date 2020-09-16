package com.k15t.pat.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.k15t.pat.server.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
