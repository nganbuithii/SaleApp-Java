package com.btn.repositories;

import com.btn.pojo.User;

import java.util.List;

public interface UserRepository {
    void addUser(User user);
   User getUsersByUsername(String username);
}
