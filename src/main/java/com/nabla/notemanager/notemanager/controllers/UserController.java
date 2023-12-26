package com.nabla.notemanager.notemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nabla.notemanager.notemanager.entities.User;
import com.nabla.notemanager.notemanager.services.UserService;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    // Read All User
    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    // Read One User
    @GetMapping("/users/{user_id}")
    public User getUserById(@PathVariable("user_id") String user_id){
        return this.userService.getUserById(Integer.parseInt(user_id));
    }

    // Create
    @PostMapping("/addUser")
	public User addUser(@RequestBody User user){
		return this.userService.addUser(user);
	}

    // Update
    @PutMapping("/update_user/{user_id}")
	public User updateUser(@PathVariable("user_id") String user_id, @RequestBody User user) {
		return this.userService.updateUser(user, Integer.parseInt(user_id));
	}

    // Delete
    @DeleteMapping("/delete_user/{user_id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable String user_id){
		try {
			this.userService.deleteUser(Integer.parseInt(user_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
