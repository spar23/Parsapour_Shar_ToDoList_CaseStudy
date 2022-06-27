package com.shar.casestudy.services;

import com.shar.casestudy.models.Status;
import com.shar.casestudy.models.User;
import com.shar.casestudy.repositories.StatusRepository;
import com.shar.casestudy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    UserRepository userRepository;

    StatusRepository statusRepository;
    @Autowired
    public StatusService(UserRepository userRepository, StatusRepository statusRepository) {
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
    }

    public void saveOrUpdate(Status status){
        statusRepository.save(status);

    }
}
