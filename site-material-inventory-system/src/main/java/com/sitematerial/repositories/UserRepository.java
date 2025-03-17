package com.sitematerial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitematerial.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}