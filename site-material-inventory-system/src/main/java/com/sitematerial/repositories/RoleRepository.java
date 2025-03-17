package com.sitematerial.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitematerial.entities.Role;
import com.sitematerial.entities.User;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRoleName(String rolename);
}