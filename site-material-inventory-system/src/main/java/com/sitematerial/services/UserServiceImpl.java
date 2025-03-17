package com.sitematerial.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitematerial.controllers.SiteController;
import com.sitematerial.customexceptions.ResourceNotFoundException;
import com.sitematerial.entities.Role;
import com.sitematerial.entities.User;
import com.sitematerial.repositories.RoleRepository;
import com.sitematerial.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    
    @Override
    public User updateuserRole(Integer id, String rolename) {
        User u = getUserById(id);
        Role role = roleRepository.findByRoleName(rolename);
        logger.info("user: {}, role: {}",u,role);
        if (u == null || role == null) {
            logger.error("User with ID {} or Role '{}' not found. Cannot update role.", id, rolename);
            return null;
        }

        u.setRole(role);
        logger.info("Role '{}' assigned to user '{}'", rolename, u.getName());
        
        return userRepository.save(u);
    }

}
