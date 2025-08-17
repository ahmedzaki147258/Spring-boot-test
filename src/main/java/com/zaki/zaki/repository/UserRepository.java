package com.zaki.zaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaki.zaki.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
