package com.shar.casestudy.repositories;

import com.shar.casestudy.models.Group;
import com.shar.casestudy.models.TodoItem;
import com.shar.casestudy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    public Group findByGroupNameAndUser(String name, User user);

}
