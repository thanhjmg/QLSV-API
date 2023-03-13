package com.kltn.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kltn.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
