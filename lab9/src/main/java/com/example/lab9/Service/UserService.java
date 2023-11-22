package com.example.lab9.Service;

import com.example.lab9.Model.User;
import com.example.lab9.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User register(User u){
        return userRepository.save(u);
    }
    public User login(String email, String password){
        return userRepository.login(email, password);
    }
}
