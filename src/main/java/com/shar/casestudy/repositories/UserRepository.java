package com.shar.casestudy.repositories;

import com.shar.casestudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username, String password);
}
