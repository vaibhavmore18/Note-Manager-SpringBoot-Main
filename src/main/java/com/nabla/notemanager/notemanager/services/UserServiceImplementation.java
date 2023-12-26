package com.nabla.notemanager.notemanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nabla.notemanager.notemanager.entities.User;
import com.nabla.notemanager.notemanager.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(int user_id) {
        return this.userRepository.findById(user_id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(int user_id) {
        this.userRepository.deleteById(user_id);
    }

    @Override
    public User updateUser(User user, Integer user_id) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword_hash(user.getPassword_hash());
            userRepository.save(existingUser);
            return existingUser;
        }else{
            return null;
        }   
    }    
}
