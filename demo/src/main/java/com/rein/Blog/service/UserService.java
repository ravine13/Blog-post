package com.rein.Blog.service;


import org.springframework.stereotype.Service;

import com.rein.Blog.repository.UserRepository;
import com.rein.Blog.Entities.User;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //create
    public User saveUser(User user){
        return userRepository.save(user);
    }
    //get
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    //getById
    public User getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }
    //getByUsername
    public User getUserByUserName(String username){
        return userRepository.findByUsername(username).orElse(null);
    }
    //update
    public User updateUser(User user){
        return userRepository.save(user);
    }
    //delete
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
