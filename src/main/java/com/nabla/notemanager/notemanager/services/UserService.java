package com.nabla.notemanager.notemanager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nabla.notemanager.notemanager.entities.User;

@Service
public interface UserService {
    public List<User> getUsers();
    public User getUserById(int user_id);
    public User addUser(User user);
    public void deleteUser(int user_id);
    public User updateUser(User user, Integer user_id);
}
