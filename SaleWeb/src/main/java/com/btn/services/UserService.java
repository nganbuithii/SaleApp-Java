package com.btn.services;

import com.btn.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);
    User getUsersByUsername(String username);
}
