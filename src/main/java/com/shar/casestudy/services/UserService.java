package com.shar.casestudy.services;

import com.shar.casestudy.models.User;
import com.shar.casestudy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
