package com.sitematerial.services;

import java.util.List;

import com.sitematerial.entities.Role;

public interface IRoleService {
    Role createRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Integer id);
    void deleteRole(Integer id);
}
